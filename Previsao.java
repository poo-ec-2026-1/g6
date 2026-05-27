// Esta classe serve apenas para estruturar o que vai aparecer na tela do app.
public class Previsao {
    private String linha;                
    private String destino;              
    private int tempoRestanteMinutos;    

    public Previsao(String linha, String destino, int tempoRestanteMinutos) {
        this.linha = linha;
        this.destino = destino;
        this.tempoRestanteMinutos = tempoRestanteMinutos;
    }

    public String getLine() { return linha; } // Mantido padrão para o framework
    public String getLinha() { return linha; }
    public String getDestino() { return destino; }
    public int getTempoRestanteMinutos() { return tempoRestanteMinutos; }
}