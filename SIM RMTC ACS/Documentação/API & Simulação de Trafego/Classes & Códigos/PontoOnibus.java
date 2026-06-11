import java.util.Objects;
/**
 * Modelo de ponto de ônibus.
 * Guarda código, nome, setor e sigla usados nas buscas e nas listas da tela.
 */
public class PontoOnibus {
    private final String codigo;
    private final String nome;
    private final String setor;
    private final String siglaSetor;
    /**
     * Cria um ponto com as informações necessárias para identificação e pesquisa.
     */
    public PontoOnibus(String codigo, String nome, String setor, String siglaSetor) {
        this.codigo = codigo;
        this.nome = nome;
        this.setor = setor;
        this.siglaSetor = siglaSetor;
    }
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getSetor() { return setor; }
    public String getSiglaSetor() { return siglaSetor; }
    /**
     * Texto resumido usado para exibição em listas e testes de terminal.
     */
    public String getDescricaoCurta() {
        return codigo + " - " + nome + " (" + setor + ")";
    }
    /**
     * Faz o ListView exibir o ponto de forma amigável.
     */
    @Override
    public String toString() {
        return getDescricaoCurta();
    }
    /**
     * Pontos são considerados iguais quando possuem o mesmo código.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PontoOnibus)) return false;
        PontoOnibus outro = (PontoOnibus) obj;
        return Objects.equals(codigo, outro.codigo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
