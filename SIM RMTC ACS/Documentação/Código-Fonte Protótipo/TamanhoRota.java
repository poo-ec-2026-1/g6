import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Resultado de uma pesquisa de rota entre dois setores.
 */
public class TamanhoRota {
    private final String origem;
    private final String destino;
    private final int tempoAproximadoMinutos;
    private final int distanciaMetros;
    private final String descricao;
    private final List<LinhaOnibus> linhasSugeridas;
    /**
     * Cria o resultado exibido na tela de pesquisa de rota.
     */
    public TamanhoRota(String origem, String destino, int tempoAproximadoMinutos,
                       int distanciaMetros, String descricao, List<LinhaOnibus> linhasSugeridas) {
        this.origem = origem;
        this.destino = destino;
        this.tempoAproximadoMinutos = tempoAproximadoMinutos;
        this.distanciaMetros = distanciaMetros;
        this.descricao = descricao;
        this.linhasSugeridas = new ArrayList<>(linhasSugeridas);
    }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public int getTempoAproximadoMinutos() { return tempoAproximadoMinutos; }
    public int getDistanciaMetros() { return distanciaMetros; }
    public String getDescricao() { return descricao; }
    public List<LinhaOnibus> getLinhasSugeridas() { return Collections.unmodifiableList(linhasSugeridas); }
    /**
     * Monta o texto principal mostrado no painel de resultado da rota.
     */
    public String getResumo() {
        return descricao + "\nTempo aproximado: " + tempoAproximadoMinutos +
               " min\nDistância aproximada: " + distanciaMetros + " m";
    }
}
