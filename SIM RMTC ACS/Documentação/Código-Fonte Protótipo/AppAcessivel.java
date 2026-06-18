import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Interface 1: SIMRMTC - ACESSIVEL
 * Programa básico isolado focado na listagem de registros em TableView
 * e inserção de novos elementos via formulário.
 */
public class AppAcessivel extends Application {

    private final ObservableList<PontoOnibus> listaPontos = FXCollections.observableArrayList();
    private final APIVirtual api = new APIVirtual();

    public static void main(String[] args) {
        launch(AppAcessivel.class, args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("SIM RMTC - ACESSÍVEL (Listagem e Cadastro)");

        // Carrega os dados iniciais fornecidos pela API simulada
        listaPontos.addAll(api.buscarPontosPorTexto(""));

        // TableView para Listar os registros
        TableView<PontoOnibus> tabela = new TableView<>();
        tabela.setItems(listaPontos);

        TableColumn<PontoOnibus, String> colCodigo = new TableColumn<>("Código");
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn<PontoOnibus, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<PontoOnibus, String> colSetor = new TableColumn<>("Setor");
        colSetor.setCellValueFactory(new PropertyValueFactory<>("setor"));

        TableColumn<PontoOnibus, String> colSigla = new TableColumn<>("Sigla");
        colSigla.setCellValueFactory(new PropertyValueFactory<>("siglaSetor"));

        tabela.getColumns().addAll(colCodigo, colNome, colSetor, colSigla);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Formulário para capturar dados fornecidos pelo usuário
        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);
        formulario.setPadding(new Insets(10, 0, 10, 0));

        TextField txtCodigo = new TextField(); 
        txtCodigo.setPromptText("Ex: SN03");
        TextField txtNome = new TextField(); 
        txtNome.setPromptText("Ex: Terminal Auxiliar");
        TextField txtSetor = new TextField(); 
        txtSetor.setPromptText("Ex: Setor Norte");
        TextField txtSigla = new TextField(); 
        txtSigla.setPromptText("Ex: SN");

        formulario.addRow(0, new Label("Código:"), txtCodigo, new Label("Nome:"), txtNome);
        formulario.addRow(1, new Label("Setor:"), txtSetor, new Label("Sigla:"), txtSigla);

        // Botão para criar e injetar o registro na TableView
        Button btnCriar = new Button("Criar Novo Registro");
        btnCriar.setStyle("-fx-background-color: #172033; -fx-text-fill: white; -fx-font-weight: bold;");
        
        btnCriar.setOnAction(e -> {
            String codigo = txtCodigo.getText();
            String nome = txtNome.getText();
            String setor = txtSetor.getText();
            String sigla = txtSigla.getText();

            if (!codigo.trim().isEmpty() && !nome.trim().isEmpty()) {
                PontoOnibus novoPonto = new PontoOnibus(codigo, nome, setor, sigla);
                listaPontos.add(novoPonto); // Atualiza dinamicamente a TableView
                
                // Limpa os campos após inserção
                txtCodigo.clear();
                txtNome.clear();
                txtSetor.clear();
                txtSigla.clear();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-background-color: #f4f6fb;");
        
        Label lbTitulo = new Label("SIMRMTC - Painel de Acessibilidade");
        lbTitulo.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #172033;");

        layout.getChildren().addAll(lbTitulo, tabela, formulario, btnCriar);

        Scene cena = new Scene(layout, 620, 460);
        stage.setScene(cena);
        stage.show();
    }
}