// ===== CONCEITO DE POO: CLASSE ABSTRATA =====
// É um molde geral. Não podemos criar um "Veiculo" genérico na rua, 
// ele precisa ser ou um Eixo ou um Convencional.
public abstract class Veiculo {
    private String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    // ===== CONCEITO DE POO: POLIMORFISMO (MÉTODO ABSTRATO) =====
    // Cada tipo de ônibus vai reescrever esse método para calcular o trânsito do seu próprio jeito.
    public abstract int calcularTempoComTrandito(int tempoOriginal);
}