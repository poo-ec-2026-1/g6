import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Classe de visão do programa.
 * Sua função é carregar o arquivo FXML e montar a tela do programa.
 */
public class TelaPrograma {
    /**
     * Carrega TelaPrograma.fxml, cria a cena num layout de aparelhos móveis e mostra a tela do programa.
     */
    public void abrir(Stage stage) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("TelaPrograma.fxml"));
        Scene cena = new Scene(raiz, 390, 760);
        stage.setTitle("SIM RMTC - ACESSIVEL");
        stage.setScene(cena);
        stage.setResizable(false);
        stage.show();
    }
}
