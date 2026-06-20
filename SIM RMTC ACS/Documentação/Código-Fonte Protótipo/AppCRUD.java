import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Operações CRUD:
 * Gerencia de forma simples as tabelas de PontoOnibus e LinhaOnibus.
 */
public class AppCRUD extends Application {

    private final ObservableList<PontoOnibus> dadosPontos = FXCollections.observableArrayList();
    private final ObservableList<LinhaOnibus> dadosLinhas = FXCollections.observableArrayList();
    private final APIVirtual api = new APIVirtual();

    public static void main(String[] args) {
        launch(AppCRUD.class, args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("AppBus Acessível- Painel Administrativo");

        // Alimentação inicial com base na estrutura simulada do programa
        dadosPontos.addAll(api.buscarPontosPorTexto(""));
        dadosLinhas.add(new LinhaOnibus("101", "Circular Norte/Sul", "Rota Base", "SN->CT->SS", "SS", new OnibusComum("BUS-101")));
        dadosLinhas.add(new LinhaOnibus("606", "Oeste/Industrial/Aeroporto", "Rota Eixo", "SO->SI->AE", "AE", new OnibusEixo("BUS-606")));

        TabPane abasPainel = new TabPane();
        
        Tab tabPontos = new Tab("CRUD - Pontos de Ônibus", configurarPainelPontos());
        tabPontos.setClosable(false);
        
        Tab tabLinhas = new Tab("CRUD - Linhas de Ônibus", configurarPainelLinhas());
        tabLinhas.setClosable(false);

        abasPainel.getTabs().addAll(tabPontos, tabLinhas);

        Scene cena = new Scene(abasPainel, 750, 520);
        stage.setScene(cena);
        stage.show();
    }

    private VBox configurarPainelPontos() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));

        TableView<PontoOnibus> tabela = new TableView<>(dadosPontos);
        
        TableColumn<PontoOnibus, String> colCod = new TableColumn<>("Código");
        colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        TableColumn<PontoOnibus, String> colNom = new TableColumn<>("Nome");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<PontoOnibus, String> colSet = new TableColumn<>("Setor");
        colSet.setCellValueFactory(new PropertyValueFactory<>("setor"));
        TableColumn<PontoOnibus, String> colSig = new TableColumn<>("Sigla");
        colSig.setCellValueFactory(new PropertyValueFactory<>("siglaSetor"));

        tabela.getColumns().addAll(colCod, colNom, colSet, colSig);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        GridPane form = new GridPane();
        form.setHgap(10); form.setVgap(10);
        TextField txtCod = new TextField(); TextField txtNom = new TextField();
        TextField txtSet = new TextField(); TextField txtSig = new TextField();

        form.addRow(0, new Label("Código:"), txtCod, new Label("Nome:"), txtNom);
        form.addRow(1, new Label("Setor:"), txtSet, new Label("Sigla:"), txtSig);

        // List para preencher formulário ao clicar na linha
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtCod.setText(novo.getCodigo());
                txtNom.setText(novo.getNome());
                txtSet.setText(novo.getSetor());
                txtSig.setText(novo.getSiglaSetor());
            }
        });

        Button btnCreate = new Button("Inserir");
        Button btnUpdate = new Button("Atualizar");
        Button btnDelete = new Button("Deletar");

        btnCreate.setOnAction(e -> {
            dadosPontos.add(new PontoOnibus(txtCod.getText(), txtNom.getText(), txtSet.getText(), txtSig.getText()));
            limparCampos(txtCod, txtNom, txtSet, txtSig);
        });

        btnUpdate.setOnAction(e -> {
            int idx = tabela.getSelectionModel().getSelectedIndex();
            if (idx >= 0) {
                dadosPontos.set(idx, new PontoOnibus(txtCod.getText(), txtNom.getText(), txtSet.getText(), txtSig.getText()));
                limparCampos(txtCod, txtNom, txtSet, txtSig);
            }
        });

        btnDelete.setOnAction(e -> {
            PontoOnibus sel = tabela.getSelectionModel().getSelectedItem();
            if (sel != null) dadosPontos.remove(sel);
        });

        HBox botoes = new HBox(10, btnCreate, btnUpdate, btnDelete);
        layout.getChildren().addAll(new Label("Gerenciamento - Entidade PontoOnibus"), tabela, form, botoes);
        return layout;
    }

    private VBox configurarPainelLinhas() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));

        TableView<LinhaOnibus> tabela = new TableView<>(dadosLinhas);
        TableColumn<LinhaOnibus, String> colNum = new TableColumn<>("Número");
        colNum.setCellValueFactory(new PropertyValueFactory<>("numero"));
        TableColumn<LinhaOnibus, String> colNom = new TableColumn<>("Nome");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<LinhaOnibus, String> colRot = new TableColumn<>("Rota Simplificada");
        colRot.setCellValueFactory(new PropertyValueFactory<>("rotaSimplificada"));

        tabela.getColumns().addAll(colNum, colNom, colRot);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        GridPane form = new GridPane();
        form.setHgap(10); form.setVgap(10);
        TextField txtNum = new TextField(); TextField txtNom = new TextField();
        TextField txtRot = new TextField();

        form.addRow(0, new Label("Número:"), txtNum, new Label("Nome:"), txtNom);
        form.addRow(1, new Label("Rota Simp:"), txtRot);

        tabela.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                txtNum.setText(novo.getNumero());
                txtNom.setText(novo.getNome());
                txtRot.setText(novo.getRotaSimplificada());
            }
        });

        Button btnCreate = new Button("Inserir");
        Button btnUpdate = new Button("Atualizar");
        Button btnDelete = new Button("Deletar");

        btnCreate.setOnAction(e -> {
            dadosLinhas.add(new LinhaOnibus(txtNum.getText(), txtNom.getText(), "Trajeto Interno", txtRot.getText(), "Fim de Rota", new OnibusComum("BUS-MOCK")));
            limparCampos(txtNum, txtNom, txtRot);
        });

        btnUpdate.setOnAction(e -> {
            int idx = tabela.getSelectionModel().getSelectedIndex();
            if (idx >= 0) {
                dadosLinhas.set(idx, new LinhaOnibus(txtNum.getText(), txtNom.getText(), "Trajeto Interno", txtRot.getText(), "Fim de Rota", new OnibusComum("BUS-MOCK")));
                limparCampos(txtNum, txtNom, txtRot);
            }
        });

        btnDelete.setOnAction(e -> {
            LinhaOnibus sel = tabela.getSelectionModel().getSelectedItem();
            if (sel != null) dadosLinhas.remove(sel);
        });

        HBox botoes = new HBox(10, btnCreate, btnUpdate, btnDelete);
        layout.getChildren().addAll(new Label("Gerenciamento - Entidade LinhaOnibus"), tabela, form, botoes);
        return layout;
    }

    private void limparCampos(TextField... campos) {
        for (TextField c : campos) c.clear();
    }
}
