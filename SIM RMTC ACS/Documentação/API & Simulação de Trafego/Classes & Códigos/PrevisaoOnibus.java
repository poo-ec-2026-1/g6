/**
 * Resultado da previsão de chegada de uma linha de ônibus em um ponto.
 */
public class PrevisaoOnibus {
    private final LinhaOnibus linha;
    private final PontoOnibus ponto;
    private final int minutosRestantes;
    private final int distanciaMetros;
    /**
     * Cria a previsão calculada pela APIVirtual.
     */
    public PrevisaoOnibus(LinhaOnibus linha, PontoOnibus ponto, int minutosRestantes, int distanciaMetros) {
        this.linha = linha;
        this.ponto = ponto;
        this.minutosRestantes = minutosRestantes;
        this.distanciaMetros = distanciaMetros;
    }
    public LinhaOnibus getLinha() { return linha; }
    public PontoOnibus getPonto() { return ponto; }
    public int getMinutosRestantes() { return minutosRestantes; }
    public int getDistanciaMetros() { return distanciaMetros; }
    /**
     * Resume a previsão em uma frase para mensagens rápidas na execusão do programa.
     */
    public String getResumo() {
        return "Linha " + linha.getNumero() + " chega em " + minutosRestantes +
               " min, a " + distanciaMetros + " m do ponto.";
    }
}
