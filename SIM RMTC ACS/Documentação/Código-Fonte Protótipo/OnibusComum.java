/**
 * Representa um ônibus convencional.
 */
public class OnibusComum extends OnibusModelo {
    public OnibusComum(String identificador) {
        super(identificador, "Convencional");
    }
    /**
     * Simula um atraso maior para as linhas comuns de ônibus devido variáveis no transito real.
     */
    @Override
    public int aplicarTransito(int minutosBase) {
        return minutosBase + 4;
    }
    /**
     * Velocidade média simulada para cálculo de distância.
     */
    @Override
    public int velocidadeMediaMetrosPorMinuto() {
        return 420;
    }
}
