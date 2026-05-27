import java.util.ArrayList;
import java.util.List;

public class Linha {
    private String numero; 
    private String nome;   
    private String destino;
    private List<Ponto> paradas = new ArrayList<>();
    private List<Integer> temposMinutos = new ArrayList<>();
    
    // ===== CONCEITO DE POO: COMPOSIÇÃO =====
    // Uma Linha "tem um" Veiculo rodando nela.
    private Veiculo veiculoEscalado; 

    public Linha(String numero, String nome, String destino, Veiculo veiculoEscalado) {
        this.numero = numero;
        this.nome = nome;
        this.destino = destino;
        this.veiculoEscalado = veiculoEscalado;
    }

    public void adicionarParada(Ponto ponto, int minutosDaPartidaAtéAqui) {
        this.paradas.add(ponto);
        this.temposMinutos.add(minutosDaPartidaAtéAqui);
    }

    public int obterTempoAteOPonto(String codigoBuscado) {
        for (int i = 0; i < paradas.size(); i++) {
            if (paradas.get(i).getCodigo().equals(codigoBuscado)) {
                int tempoBase = temposMinutos.get(i);
                
                // MÁGICA DO POLIMORFISMO EM AÇÃO:
                // O Java decide sozinho na hora se usa a regra do Eixo ou do Convencional!
                return veiculoEscalado.calcularTempoComTrandito(tempoBase);
            }
        }
        return -1; 
    }

    public String getNumero() { return numero; }
    public String getNome() { return nome; }
    public String getDestino() { return destino; }
}