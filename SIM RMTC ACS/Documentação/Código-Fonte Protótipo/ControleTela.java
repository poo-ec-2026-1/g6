import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.List;
/**
 * Classe de controle da tela principal.
 * Ela recebe ações do usuário, consulta a APIVirtual e atualiza os elementos do FXML.
 */
public class ControleTela {
    private final TrafegoTransporte api = new APIVirtual();
    private PontoOnibus pontoSelecionado;
    @FXML private Button botaoTelaPontoLinha;
    @FXML private Button botaoTelaRota;
    @FXML private VBox telaPontoLinha;
    @FXML private VBox telaRota;
    @FXML private TextField campoPesquisaPontoLinha;
    @FXML private ListView<PontoOnibus> listaPontos;
    @FXML private ListView<LinhaOnibus> listaLinhas;
    @FXML private Label textoResultadoPontoLinha;
    @FXML private TextField campoOrigem;
    @FXML private TextField campoDestino;
    @FXML private Label textoTamanhoRota;
    @FXML private ListView<LinhaOnibus> listaLinhasRota;
    /**
     * Método chamado automaticamente após o FXML ser carregado.
     * Configura as listas, abre a aba de ponto ou linha e faz uma busca inicial de exemplo.
     */
    @FXML
    private void initialize() {
        configurarListaPontos();
        configurarListaLinhas(listaLinhas);
        configurarListaLinhas(listaLinhasRota);
        mostrarTelaPontoLinha();

        campoPesquisaPontoLinha.setText("Setor Sul");
        pesquisarPontoOuSetor();
    }
    /**
     * Mostra a área de pesquisa de ponto e linha, escondendo a pesquisa de rota.
     */
    @FXML
    private void mostrarTelaPontoLinha() {
        telaPontoLinha.setVisible(true);
        telaPontoLinha.setManaged(true);
        telaRota.setVisible(false);
        telaRota.setManaged(false);
        botaoTelaPontoLinha.setStyle(estiloBotaoAtivo());
        botaoTelaRota.setStyle(estiloBotaoInativo());
    }
    /**
     * Mostra a área de pesquisa de rota, escondendo a pesquisa de ponto e linha.
     */
    @FXML
    private void mostrarTelaRota() {
        telaPontoLinha.setVisible(false);
        telaPontoLinha.setManaged(false);
        telaRota.setVisible(true);
        telaRota.setManaged(true);
        botaoTelaPontoLinha.setStyle(estiloBotaoInativo());
        botaoTelaRota.setStyle(estiloBotaoAtivo());
    }
    /**
     * Executa a busca principal.
     * Se o usuário digitar um ponto, mostra as linhas do ponto digitado.
     * Se digitar um setor, mostra os pontos disponíveis naquele setor digitado.
     */
    @FXML
    private void pesquisarPontoOuSetor() {
        String termo = campoPesquisaPontoLinha.getText();
        pontoSelecionado = null;
        listaPontos.getItems().clear();
        listaLinhas.getItems().clear();
        if (termo == null || termo.trim().isEmpty()) {
            textoResultadoPontoLinha.setText("Digite o codigo do ponto ou o setor - EX: SS01, 01, Setor Sul, setorsul ou SS.");
            return;
        }
        PontoOnibus ponto = api.buscarPontoPorCodigo(termo);
        if (ponto != null) {
            selecionarPonto(ponto);
            listaPontos.getItems().setAll(ponto);
            listaPontos.getSelectionModel().select(ponto);
            return;
        }
        List<PontoOnibus> pontos = api.buscarPontosPorTexto(termo);
        listaPontos.getItems().setAll(pontos);

        if (pontos.isEmpty()) {
            textoResultadoPontoLinha.setText("Nenhum ponto ou setor encontrado para: " + termo);
        } else {
            textoResultadoPontoLinha.setText("Selecione um ponto da lista para ver as linhas que passam por ele.");
        }
    }
    /**
     * Calcula a rota entre origem e destino informados pelo usuário.
     */
    @FXML
    private void calcularRota() {
        String origem = campoOrigem.getText();
        String destino = campoDestino.getText();
        listaLinhasRota.getItems().clear();

        if (origem == null || origem.trim().isEmpty() || destino == null || destino.trim().isEmpty()) {
            textoTamanhoRota.setText("Informe a localidade de origem e a localidade de destino.");
            return;
        }

        TamanhoRota resultado = api.calcularRotaEntreSetores(origem, destino);
        textoTamanhoRota.setText(resultado.getResumo());
        listaLinhasRota.getItems().setAll(resultado.getLinhasSugeridas());
    }
    /**
     * Define como os pontos aparecem na lista e liga a seleção do ponto à busca de linhas.
     */
    private void configurarListaPontos() {
        listaPontos.setCellFactory(view -> new ListCell<PontoOnibus>() {
            @Override
            protected void updateItem(PontoOnibus ponto, boolean vazio) {
                super.updateItem(ponto, vazio);
                if (vazio || ponto == null) {
                    setText(null);
                } else {
                    setText(ponto.getCodigo() + "  " + ponto.getNome() + "\n" + ponto.getSetor() + "  |  " + ponto.getSiglaSetor());
                }
            }
        });
        listaPontos.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) selecionarPonto(novo);
        });
    }
    /**
     * Define como as linhas aparecem nas listas.
     * Na lista principal, também dispara a previsão ao selecionar uma linha.
     */
    private void configurarListaLinhas(ListView<LinhaOnibus> lista) {
        lista.setCellFactory(view -> new ListCell<LinhaOnibus>() {
            @Override
            protected void updateItem(LinhaOnibus linha, boolean vazio) {
                super.updateItem(linha, vazio);
                if (vazio || linha == null) {
                    setText(null);
                } else {
                    setText("Linha " + linha.getNumero() + " - " + linha.getNome()
                            + "\nRota: " + linha.getRotaSimplificada()
                            + "\nDestino: " + linha.getDestino());
                }
            }
        });
        if (lista == listaLinhas) {
            lista.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
                if (novo != null && pontoSelecionado != null) mostrarPrevisao(novo);
            });
        }
    }
    /**
     * Guarda o ponto selecionado e carrega as linhas que passam por ele.
     */
    private void selecionarPonto(PontoOnibus ponto) {
        pontoSelecionado = ponto;
        List<LinhaOnibus> linhas = api.buscarLinhasPorPonto(ponto.getCodigo());
        listaLinhas.getItems().setAll(linhas);
        textoResultadoPontoLinha.setText("Ponto selecionado: " + ponto.getCodigo() + " - " + ponto.getNome()
                + "\nLinhas encontradas: " + linhas.size() + ". Selecione uma linha para ver chegada e distancia.");
    }
    /**
     * Mostra tempo de chegada, distância do ônibus e rota simplificada da linha selecionada.
     */
    private void mostrarPrevisao(LinhaOnibus linha) {
        PrevisaoOnibus previsao = api.calcularPrevisao(pontoSelecionado.getCodigo(), linha.getNumero());
        if (previsao == null) {
            textoResultadoPontoLinha.setText("Nao foi possivel calcular a previsao para essa linha.");
            return;
        }

        textoResultadoPontoLinha.setText(
                "Ponto: " + pontoSelecionado.getCodigo() + " - " + pontoSelecionado.getNome() + "\n" +
                "Linha " + linha.getNumero() + " - " + linha.getNome() + "\n" +
                "Chegada: " + previsao.getMinutosRestantes() + " minutos\n" +
                "Distancia do onibus ate o ponto: " + previsao.getDistanciaMetros() + " metros\n" +
                "Rota simplificada: " + linha.getRotaSimplificada()
        );
    }
    /**
     * Estilo usado para o botão da tela aberta.
     */
    private String estiloBotaoAtivo() {
        return "-fx-background-color: #172033; -fx-text-fill: white; -fx-background-radius: 16; -fx-font-weight: bold; -fx-padding: 10;";
    }
    /**
     * Estilo usado para o botão da tela fechada.
     */
    private String estiloBotaoInativo() {
        return "-fx-background-color: white; -fx-text-fill: #172033; -fx-background-radius: 16; -fx-border-color: #d5dbea; -fx-border-radius: 16; -fx-font-weight: bold; -fx-padding: 10;";
    }
}
