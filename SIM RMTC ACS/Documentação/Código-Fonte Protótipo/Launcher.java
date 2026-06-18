import javafx.application.Platform;
import javafx.stage.Stage;

public class Launcher {
    public static void main(String[] args) {

        Platform.runLater(() -> {
            try {
                // Instancia a classe da interface selecionada
                // Para iniciar uma interfece basta comentar outra
                AppCRUD app = new AppCRUD();
                // AppAcessivel app = new AppAcessivel();
                
                // Força a inicialização da classe
                Stage palco = new Stage();
                app.start(palco);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}