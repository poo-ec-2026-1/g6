/**
 * Representa um ônibus de eixo.
 * Ele tem menor tempo de chegada e velocidade média superior dado o eu trafego "preferêncial".
 */
public class OnibusEixo extends OnibusModelo {
    public OnibusEixo(String identificador) {
        super(identificador, "Eixo/Rápido");
    }
    /**
     * Reduz o tempo base para representar uma linha mais rápida.
     */
    @Override
    public int aplicarTransito(int minutosBase) {
        return Math.max(1, minutosBase - 1);
    }
    /**
     * Velocidade média simulada para cálculo de distância.
     */
    @Override
    public int velocidadeMediaMetrosPorMinuto() {
        return 560;
    }
}
