import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Modelo de uma linha de ônibus.
 * Relaciona número, nome, rota, ônibus responsável e pontos a serem percorridos por certa linha.
 */
public class LinhaOnibus {
    private final String numero;
    private final String nome;
    private final String rotaCompleta;
    private final String rotaSimplificada;
    private final String destino;
    private final OnibusModelo onibus;
    private final List<PontoOnibus> pontos = new ArrayList<>();
    private final List<Integer> temposAtePonto = new ArrayList<>();
    /**
     * Cria a linha com dados iniciais para a simulação do trafego.
     */
    public LinhaOnibus(String numero, String nome, String rotaCompleta, String rotaSimplificada,
                       String destino, OnibusModelo onibus) {
        this.numero = numero;
        this.nome = nome;
        this.rotaCompleta = rotaCompleta;
        this.rotaSimplificada = rotaSimplificada;
        this.destino = destino;
        this.onibus = onibus;
    }
    /**
     * Liga um ponto à uma determinada linha e guarda o tempo estimado da partida até esse ponto destinado.
     */
    public void adicionarPonto(PontoOnibus ponto, int minutosDaPartida) {
        pontos.add(ponto);
        temposAtePonto.add(minutosDaPartida);
    }
    /**
     * Verifica se a linha passa por um ponto em específico.
     */
    public boolean passaNoPonto(String codigoPonto) {
        return pontos.stream().anyMatch(p -> p.getCodigo().equalsIgnoreCase(codigoPonto));
    }
    /**
     * Verifica se a linha passa por um setor já normalizado pela APIVirtual.
     */
    public boolean passaNoSetorNormalizado(String setorNormalizado) {
        return pontos.stream().anyMatch(p -> APIVirtual.normalizarTexto(p.getSetor()).equals(setorNormalizado)
                || APIVirtual.normalizarTexto(p.getSiglaSetor()).equals(setorNormalizado));
    }
    /**
     * Calcula o tempo de chegada até o ponto, já aplicando o comportamento do tipo de ônibus (Comum ou Eixo).
     */
    public int tempoAtePonto(String codigoPonto) {
        for (int i = 0; i < pontos.size(); i++) {
            if (pontos.get(i).getCodigo().equalsIgnoreCase(codigoPonto)) {
                return onibus.aplicarTransito(temposAtePonto.get(i));
            }
        }
        return -1;
    }
    /**
     * Retorna a posição do primeiro ponto que pertence ao setor informado pelo usuário.
     */
    public int indiceDoSetor(String setorNormalizado) {
        for (int i = 0; i < pontos.size(); i++) {
            PontoOnibus ponto = pontos.get(i);
            if (APIVirtual.normalizarTexto(ponto.getSetor()).equals(setorNormalizado)
                    || APIVirtual.normalizarTexto(ponto.getSiglaSetor()).equals(setorNormalizado)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Retorna as siglas dos setores da linha sem repetição, preservando a ordem da rota.
     */
    public Set<String> getSiglasDosSetores() {
        return pontos.stream()
                .map(PontoOnibus::getSiglaSetor)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public String getNumero() { return numero; }
    public String getNome() { return nome; }
    public String getRotaCompleta() { return rotaCompleta; }
    public String getRotaSimplificada() { return rotaSimplificada; }
    public String getDestino() { return destino; }
    public OnibusModelo getOnibus() { return onibus; }
    public List<PontoOnibus> getPontos() { return Collections.unmodifiableList(pontos); }
    /**
     * Texto exibido quando a linha aparece em listas simples.
     */
    @Override
    public String toString() {
        return numero + " - " + nome + " (" + rotaSimplificada + ")";
    }
}
