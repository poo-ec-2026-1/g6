/**
 * Classe de execusão pelo terminal da IDE.
 */
public class ExecutarTerminal {
    /**
     * Executa consultas simples: setores, pontos, linhas, previsão e rota.
     */
    public static void main(String[] args) {
        APIVirtual api = new APIVirtual();
        System.out.println("Setores disponiveis:");
        for (String setor : api.listarSetores()) {
            System.out.println("- " + setor);
        }
        System.out.println("\nBusca por 'SS':");
        for (PontoOnibus ponto : api.buscarPontosPorTexto("SS")) {
            System.out.println("- " + ponto.getDescricaoCurta());
            System.out.println("  Linhas: " + api.buscarLinhasPorPonto(ponto.getCodigo()).size());
        }
        System.out.println("\nBusca direta por ponto 'SS01':");
        PontoOnibus ponto = api.buscarPontoPorCodigo("SS01");
        System.out.println(ponto.getDescricaoCurta());
        for (LinhaOnibus linha : api.buscarLinhasPorPonto(ponto.getCodigo())) {
            System.out.println("- Linha " + linha.getNumero() + " | " + linha.getRotaSimplificada());
        }
        PrevisaoOnibus previsao = api.calcularPrevisao("SS01", "101");
        System.out.println("\nPrevisao:");
        System.out.println(previsao.getResumo());

        TamanhoRota rota = api.calcularRotaEntreSetores("setornorte", "SS");
        System.out.println("\nRota Norte -> Sul:");
        System.out.println(rota.getResumo());
    }
}
