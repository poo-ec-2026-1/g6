// ===== CONCEITO DE POO: HERANÇA =====
// Classe Ônibus Eixo herda tudo o que o Veiculo tem usando a palavra 'extends'
public class OnibusEixo extends Veiculo {

    public OnibusEixo(String placa) {
        super(placa);
    }

    // ===== CONCEITO DE POO: POLIMORFISMO (SOBREPOSIÇÃO) =====
    // O Eixo tem pista exclusiva em Goiânia, então ele não pega trânsito (atraso = 0).
    @Override
    public int calcularTempoComTrandito(int tempoOriginal) {
        return tempoOriginal; 
    }
}
