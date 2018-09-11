import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    private static ScreenController screenController;

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScene(String sceneName) {
        screenController.activate(sceneName);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Cinema");

        Parent root = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));

        Scene mainScene = new Scene(root, 900, 600);
        screenController = new ScreenController(mainScene);

        screenController.addScreen("Login", FXMLLoader.load(getClass().getResource("loginWindow.fxml")));
        screenController.addScreen("Main", FXMLLoader.load(getClass().getResource("mainWindow.fxml")));
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
