import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Classe principal de execução do programa JavaFX por um todo.
 */
public class ExecutarPrograma extends Application {
    /**
     * Método chamado automaticamente pelo JavaFX.
     * Ele cria a tela principal e entrega parâmetros para a classe de visão do programa.
     */
    @Override
    public void start(Stage stage) throws Exception {
        TelaPrograma tela = new TelaPrograma();
        tela.abrir(stage);
    }
    /**
     * Método interno para iniciar o programa por um todo a partir de outras classes.
     */
    public static void executarPrograma(String[] args) {
        launch(args);
    }
    /**
     * Ponto de entrada e inicialização comum.
     */
    public static void main(String[] args) {
        executarPrograma(args);
    }
}
