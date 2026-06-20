import java.text.Normalizer;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Base de dados simulada do programa.
 * Centraliza e organiza setores, pontos, linhas, rotas, aliases de pesquisa e previsões fictícias simuladas com valores pré-definidos.
 */
public class APIVirtual implements TrafegoTransporte {
    private final Map<String, PontoOnibus> pontos = new LinkedHashMap<>();
    private final List<LinhaOnibus> linhas = new ArrayList<>();
    private final Map<String, String> setorPorAlias = new LinkedHashMap<>();
    /**
     * Ao criar a API, todos os dados virtuais são cadastrados em memória.
     */
    public APIVirtual() {
        cadastrarSetores();
        cadastrarPontos();
        cadastrarLinhas();
    }
    /**
     * Cadastra os setores e suas formas alternativas de escrita (facilitando como o usuário informar o setor desejado), como siglas e nomes sem espaço.
     */
    private void cadastrarSetores() {
        setor("Setor Norte", "SN", "norte", "setornorte");
        setor("Setor Sul", "SS", "sul", "setorsul");
        setor("Setor Leste", "SL", "leste", "setorleste");
        setor("Setor Oeste", "SO", "oeste", "setoroeste");
        setor("Centro", "CT", "central", "centro", "setorcentral");
        setor("Setor Industrial", "SI", "industrial", "setorindustrial");
        setor("Campus Universitario", "CU", "campus", "universitario", "campusuniversitario");
        setor("Aeroporto", "AE", "aero", "aeroporto");
        setor("Setor Bueno", "SB", "bueno", "setorbueno");
        setor("Jardim America", "JA", "jardimamerica", "jardim", "setorjardimamerica");
        setor("Setor Universitario", "SU", "setoruniversitario", "universitario");
        setor("Pedro Ludovico", "PL", "pedroludovico", "setorpedroludovico");
    }
    /**
     * Registra um setor canônico e todos os "apelidos" aceitos na pesquisa.
     */
    private void setor(String nomeCanonico, String sigla, String... apelidos) {
        setorPorAlias.put(normalizarTexto(nomeCanonico), nomeCanonico);
        setorPorAlias.put(normalizarTexto(sigla), nomeCanonico);
        for (String apelido : apelidos) {
            setorPorAlias.put(normalizarTexto(apelido), nomeCanonico);
        }
    }
    /**
     * Cria os pontos de ônibus disponíveis para a simulação.
     */
    private void cadastrarPontos() {
        ponto("SN01", "Praca Civica Norte", "Setor Norte", "SN");
        ponto("SN02", "Supermercado Central Norte", "Setor Norte", "SN");
        ponto("SS01", "Shopping do Sul", "Setor Sul", "SS");
        ponto("SS02", "Hospital de Clinicas", "Setor Sul", "SS");
        ponto("SL01", "Estacao Leste", "Setor Leste", "SL");
        ponto("SL02", "Escola Municipal Rich", "Setor Leste", "SL");
        ponto("SO01", "Terminal Oeste", "Setor Oeste", "SO");
        ponto("SO02", "Parque das Flores", "Setor Oeste", "SO");
        ponto("CT01", "Terminal Central", "Centro", "CT");
        ponto("CT02", "Mercado Central", "Centro", "CT");
        ponto("SI01", "Entrada da Fabrica EMC", "Setor Industrial", "SI");
        ponto("SI02", "Almoxarifado Central", "Setor Industrial", "SI");
        ponto("CU01", "Campus Universitario", "Campus Universitario", "CU");
        ponto("CU02", "Biblioteca Central", "Campus Universitario", "CU");
        ponto("AE01", "Aeroporto - Embarque", "Aeroporto", "AE");
        ponto("AE02", "Aeroporto - Desembarque", "Aeroporto", "AE");
        ponto("SB01", "Avenida T-7", "Setor Bueno", "SB");
        ponto("SB02", "Praca do Bueno", "Setor Bueno", "SB");
        ponto("JA01", "Jardim America I", "Jardim America", "JA");
        ponto("JA02", "Jardim America II", "Jardim America", "JA");
        ponto("SU01", "Faculdade de Letras", "Setor Universitario", "SU");
        ponto("SU02", "Hospital Universitario", "Setor Universitario", "SU");
        ponto("PL01", "Praca Pedro Ludovico", "Pedro Ludovico", "PL");
        ponto("PL02", "Avenida Circular", "Pedro Ludovico", "PL");
    }
    /**
     * Cria as linhas e distribui seus trajetos pelos setores cadastrados.
     */
    private void cadastrarLinhas() {
        linha("101", "Circular Norte/Sul", "Setor Norte -> Centro -> Setor Sul", new OnibusComum("BUS-101"), "SN", "CT", "SS");
        linha("202", "Leste/Norte/Oeste", "Setor Leste -> Setor Norte -> Setor Oeste", new OnibusComum("BUS-202"), "SL", "SN", "SO");
        linha("303", "Sul/Centro/Leste", "Setor Sul -> Centro -> Setor Leste", new OnibusComum("BUS-303"), "SS", "CT", "SL");
        linha("404", "Industrial/Oeste/Centro", "Setor Industrial -> Setor Oeste -> Centro", new OnibusComum("BUS-404"), "SI", "SO", "CT");
        linha("505", "Campus/Leste/Sul", "Campus Universitario -> Setor Leste -> Setor Sul", new OnibusComum("BUS-505"), "CU", "SL", "SS");
        linha("606", "Oeste/Industrial/Aeroporto", "Setor Oeste -> Setor Industrial -> Aeroporto", new OnibusEixo("BUS-606"), "SO", "SI", "AE");
        linha("707", "Bueno/Jardim/Aeroporto", "Setor Bueno -> Jardim America -> Aeroporto", new OnibusEixo("BUS-707"), "SB", "JA", "AE");
        linha("808", "Campus/Industrial/Bueno", "Campus Universitario -> Setor Industrial -> Setor Bueno", new OnibusEixo("BUS-808"), "CU", "SI", "SB");
        linha("909", "Oeste/Bueno/Centro", "Setor Oeste -> Setor Bueno -> Centro", new OnibusComum("BUS-909"), "SO", "SB", "CT");
        linha("111", "Jardim/Sul/Universitario", "Jardim America -> Setor Sul -> Setor Universitario", new OnibusComum("BUS-111"), "JA", "SS", "SU");
        linha("222", "Universitario/Centro/Campus", "Setor Universitario -> Centro -> Campus Universitario", new OnibusComum("BUS-222"), "SU", "CT", "CU");
        linha("333", "Pedro Ludovico/Sul/Leste", "Pedro Ludovico -> Setor Sul -> Setor Leste", new OnibusComum("BUS-333"), "PL", "SS", "SL");
        linha("444", "Norte/Universitario/Campus", "Setor Norte -> Setor Universitario -> Campus Universitario", new OnibusEixo("BUS-444"), "SN", "SU", "CU");
        linha("555", "Jardim/Bueno/Oeste", "Jardim America -> Setor Bueno -> Setor Oeste", new OnibusComum("BUS-555"), "JA", "SB", "SO");
        linha("666", "Pedro/Aeroporto/Industrial", "Pedro Ludovico -> Aeroporto -> Setor Industrial", new OnibusEixo("BUS-666"), "PL", "AE", "SI");
        linha("777", "Norte/Bueno/Jardim", "Setor Norte -> Setor Bueno -> Jardim America", new OnibusComum("BUS-777"), "SN", "SB", "JA");
        linha("888", "Industrial/Pedro/Campus", "Setor Industrial -> Pedro Ludovico -> Campus Universitario", new OnibusComum("BUS-888"), "SI", "PL", "CU");
        linha("999", "Aeroporto/Universitario/Pedro", "Aeroporto -> Setor Universitario -> Pedro Ludovico", new OnibusEixo("BUS-999"), "AE", "SU", "PL");
    }
    /**
     * Método auxiliar para inserir um ponto no mapa usando seu código como chave.
     */
    private void ponto(String codigo, String nome, String setor, String siglaSetor) {
        pontos.put(codigo, new PontoOnibus(codigo, nome, setor, siglaSetor));
    }
    /**
     * Método auxiliar para criar uma linha, montar sua rota simplificada e vincular seus pontos.
     */
    private void linha(String numero, String nome, String rotaCompleta, OnibusModelo onibus, String... siglasSetores) {
        String destino = nomeDoSetorPorSigla(siglasSetores[siglasSetores.length - 1]);
        String rotaSimplificada = String.join("->", siglasSetores);
        LinhaOnibus linha = new LinhaOnibus(numero, nome, rotaCompleta, rotaSimplificada, destino, onibus);

        int tempo = 3;
        for (String sigla : siglasSetores) {
            for (PontoOnibus ponto : pontosPorSigla(sigla)) {
                linha.adicionarPonto(ponto, tempo);
                tempo += 4;
            }
        }
        linhas.add(linha);
    }
    /**
     * Converte uma sigla em nome de setor para exibição de destino.
     */
    private String nomeDoSetorPorSigla(String sigla) {
        String canonico = setorPorAlias.get(normalizarTexto(sigla));
        return canonico == null ? sigla : canonico;
    }
    /**
     * Retorna todos os pontos pertencentes a um setor identificado por sigla.
     */
    private List<PontoOnibus> pontosPorSigla(String sigla) {
        return pontos.values().stream()
                .filter(p -> p.getSiglaSetor().equalsIgnoreCase(sigla))
                .collect(Collectors.toList());
    }
    @Override
    /**
     * Lista setores únicos, ordenados alfabeticamente.
     */
    public List<String> listarSetores() {
        return pontos.values().stream()
                .map(PontoOnibus::getSetor)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    @Override
    /**
     * Busca pontos de um setor aceitando nomes variados, siglas e apelidos.
     */
    public List<PontoOnibus> buscarPontosPorSetor(String setor) {
        String setorCanonico = resolverSetor(setor);
        if (setorCanonico == null) return new ArrayList<>();

        return pontos.values().stream()
                .filter(p -> p.getSetor().equals(setorCanonico))
                .sorted(Comparator.comparing(PontoOnibus::getCodigo))
                .collect(Collectors.toList());
    }
    @Override
    /**
     * Busca geral usada pela tela inicial: aceita código de ponto, nome, setor ou sigla.
     */
    public List<PontoOnibus> buscarPontosPorTexto(String texto) {
        String termo = normalizarTexto(texto);
        String setorCanonico = resolverSetor(texto);

        return pontos.values().stream()
                .filter(p -> {
                    if (setorCanonico != null && p.getSetor().equals(setorCanonico)) return true;
                    return normalizarTexto(p.getCodigo()).contains(termo)
                            || normalizarTexto(p.getNome()).contains(termo)
                            || normalizarTexto(p.getSetor()).contains(termo)
                            || normalizarTexto(p.getSiglaSetor()).equals(termo);
                })
                .sorted(Comparator.comparing(PontoOnibus::getCodigo))
                .collect(Collectors.toList());
    }
    @Override
    /**
     * Busca direta por código completo ou pelo número final do ponto.
     */
    public PontoOnibus buscarPontoPorCodigo(String codigoOuNumero) {
        String termo = normalizarTexto(codigoOuNumero);
        if (termo.isEmpty()) return null;
        for (PontoOnibus ponto : pontos.values()) {
            String codigo = normalizarTexto(ponto.getCodigo());
            if (codigo.equals(termo) || codigo.endsWith(termo)) {
                return ponto;
            }
        }
        return null;
    }
    @Override
    /**
     * Encontra todas as linhas que atendem o ponto selecionado.
     */
    public List<LinhaOnibus> buscarLinhasPorPonto(String codigoPonto) {
        return linhas.stream()
                .filter(l -> l.passaNoPonto(codigoPonto))
                .sorted(Comparator.comparing(LinhaOnibus::getNumero))
                .collect(Collectors.toList());
    }
    @Override
    /**
     * Retorna linhas diretas que passam tanto no setor de origem quanto no de destino.
     */
    public List<LinhaOnibus> buscarRotasPorSetores(String setorOrigem, String setorDestino) {
        String origem = normalizarSetorParaBusca(setorOrigem);
        String destino = normalizarSetorParaBusca(setorDestino);
        if (origem.isEmpty() || destino.isEmpty()) return new ArrayList<>();
        return linhas.stream()
                .filter(l -> l.passaNoSetorNormalizado(origem))
                .filter(l -> l.passaNoSetorNormalizado(destino))
                .sorted(Comparator.comparing(LinhaOnibus::getNumero))
                .collect(Collectors.toList());
    }
    @Override
    /**
     * Calcula uma rota aproximada entre dois setores, tentando primeiro linha direta e depois conexão.
     */
    public TamanhoRota calcularRotaEntreSetores(String setorOrigem, String setorDestino) {
        String origemCanonica = resolverSetor(setorOrigem);
        String destinoCanonico = resolverSetor(setorDestino);
        if (origemCanonica == null || destinoCanonico == null) {
            return new TamanhoRota(setorOrigem, setorDestino, 0, 0,
                    "Nao foi possivel reconhecer um dos setores informados.", new ArrayList<>());
        }
        String origem = normalizarTexto(origemCanonica);
        String destino = normalizarTexto(destinoCanonico);
        List<LinhaOnibus> diretas = buscarRotasPorSetores(origemCanonica, destinoCanonico);
        if (!diretas.isEmpty()) {
            LinhaOnibus melhor = diretas.get(0);
            int tempo = estimarTempoEntreSetores(melhor, origem, destino);
            int distancia = tempo * melhor.getOnibus().velocidadeMediaMetrosPorMinuto();
            return new TamanhoRota(origemCanonica, destinoCanonico, tempo, distancia,
                    "Rota direta sugerida pela linha " + melhor.getNumero() + " - " + melhor.getRotaSimplificada(), diretas);
        }
        for (LinhaOnibus primeira : linhas) {
            if (!primeira.passaNoSetorNormalizado(origem)) continue;
            for (LinhaOnibus segunda : linhas) {
                if (!segunda.passaNoSetorNormalizado(destino)) continue;
                Set<String> conexoes = new LinkedHashSet<>(primeira.getSiglasDosSetores());
                conexoes.retainAll(segunda.getSiglasDosSetores());
                if (!conexoes.isEmpty()) {
                    String conexao = conexoes.iterator().next();
                    int tempo = 34 + primeira.getOnibus().aplicarTransito(4) + segunda.getOnibus().aplicarTransito(4);
                    int distancia = tempo * 470;
                    return new TamanhoRota(origemCanonica, destinoCanonico, tempo, distancia,
                            "Rota com conexao em " + conexao + ": linha " + primeira.getNumero() +
                            " e depois linha " + segunda.getNumero() + ".", Arrays.asList(primeira, segunda));
                }
            }
        }
        int tempo = 45;
        return new TamanhoRota(origemCanonica, destinoCanonico, tempo, tempo * 430,
                "Rota aproximada sem linha direta cadastrada.", new ArrayList<>());
    }
    @Override
    /**
     * Simula a previsão de chegada usando horário atual, intervalo da linha e velocidade do ônibus.
     */
    public PrevisaoOnibus calcularPrevisao(String codigoPonto, String numeroLinha) {
        PontoOnibus ponto = pontos.get(codigoPonto);
        if (ponto == null) return null;
        for (LinhaOnibus linha : linhas) {
            if (linha.getNumero().equals(numeroLinha) && linha.passaNoPonto(codigoPonto)) {
                int base = linha.tempoAtePonto(codigoPonto);
                int intervalo = linha.getOnibus() instanceof OnibusEixo ? 8 : 12;
                int ciclo = LocalTime.now().getMinute() % intervalo;
                int minutos = Math.max(1, base + intervalo - ciclo);
                int distancia = Math.max(120, minutos * linha.getOnibus().velocidadeMediaMetrosPorMinuto());
                return new PrevisaoOnibus(linha, ponto, minutos, distancia);
            }
        }
        return null;
    }
    /**
     * Estima tempo entre dois setores dentro da mesma linha usando a distância entre índices da rota.
     */
    private int estimarTempoEntreSetores(LinhaOnibus linha, String origem, String destino) {
        int indiceOrigem = linha.indiceDoSetor(origem);
        int indiceDestino = linha.indiceDoSetor(destino);
        int diferenca = Math.abs(indiceDestino - indiceOrigem);
        int tempo = 8 + (diferenca * 4);
        return linha.getOnibus().aplicarTransito(tempo);
    }
    /**
     * Resolve o nome do setor e devolve sua forma normalizada para comparações internas.
     */
    private String normalizarSetorParaBusca(String texto) {
        String setor = resolverSetor(texto);
        return setor == null ? "" : normalizarTexto(setor);
    }
    /**
     * Interpreta o texto digitado pelo usuário e tenta encontrar o setor canônico equivalente.
     */
    private String resolverSetor(String texto) {
        String normalizado = normalizarTexto(texto);
        if (normalizado.isEmpty()) return null;
        if (setorPorAlias.containsKey(normalizado)) return setorPorAlias.get(normalizado);
        for (Map.Entry<String, String> entrada : setorPorAlias.entrySet()) {
            if (entrada.getKey().contains(normalizado) || normalizado.contains(entrada.getKey())) {
                return entrada.getValue();
            }
        }
        return null;
    }
    /**
     * Remove acentos, espaços e símbolos, deixando o texto pronto para buscas flexíveis.
     */
    public static String normalizarTexto(String texto) {
        if (texto == null) return "";
        String semAcento = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return semAcento.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}
