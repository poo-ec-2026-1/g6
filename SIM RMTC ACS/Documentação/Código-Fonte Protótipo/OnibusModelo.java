/**
 * Modelo base para qualquer ônibus do sistema.
 * As subclasses definem como o tipo de ônibus afeta tempo e velocidade média.
 */
public abstract class OnibusModelo {
    private final String identificador;
    private final String tipo;
    /**
     * Guarda a identificação simulada do ônibus e o tipo exibido ao usuário.
     */
    public OnibusModelo(String identificador, String tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }
    public String getIdentificador() { return identificador; }
    public String getTipo() { return tipo; }
    /**
     * Ajusta o tempo base considerando o comportamento do tipo de ônibus.
     */
    public abstract int aplicarTransito(int minutosBase);
    /**
     * Retorna a velocidade média simulada em metros por minuto.
     */
    public abstract int velocidadeMediaMetrosPorMinuto();
}
