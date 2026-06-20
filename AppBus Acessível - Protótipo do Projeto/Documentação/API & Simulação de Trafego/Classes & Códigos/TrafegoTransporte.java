import java.util.List;
/**
 * Define o que o serviço de tráfego oferece para a tela e o controle de tela.
 */
public interface TrafegoTransporte {
    /** Lista todos os setores cadastrados. */
    List<String> listarSetores();
    /** Busca pontos usando o nome, sigla ou apelido de um setor. */
    List<PontoOnibus> buscarPontosPorSetor(String setor);
    /** Busca pontos por código, nome, setor ou sigla. */
    List<PontoOnibus> buscarPontosPorTexto(String texto);
    /** Busca um ponto pelo código completo ou pelo número final do código. */
    PontoOnibus buscarPontoPorCodigo(String codigoOuNumero);
    /** Retorna as linhas que passam por um ponto específico. */
    List<LinhaOnibus> buscarLinhasPorPonto(String codigoPonto);
    /** Retorna linhas capazes de ligar dois setores. */
    List<LinhaOnibus> buscarRotasPorSetores(String setorOrigem, String setorDestino);
    /** Calcula uma rota aproximada entre dois setores. */
    TamanhoRota calcularRotaEntreSetores(String setorOrigem, String setorDestino);
    /** Calcula previsão de chegada de uma linha em um ponto. */
    PrevisaoOnibus calcularPrevisao(String codigoPonto, String numeroLinha);
}
