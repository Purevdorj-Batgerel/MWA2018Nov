package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ScreenController {
    private HashMap<String, String> screenMap = new HashMap<>();
    private Stage main;

    public ScreenController(Stage main) {
        this.main = main;
    }

    protected void addScreen(String name, String pane) {
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name) {
        screenMap.remove(name);
    }

    protected void activate(String name) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(screenMap.get(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene mainScene = new Scene(root, 900, 600);
        main.setScene(mainScene);

//        try {
//            Parent root = FXMLLoader.load(getClass().getResource(screenMap.get(name)));
//            main.setRoot(root);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    protected void activate(String name, String key, Object value) {

        activate(name);
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource(screenMap.get(name)));
//            main.setRoot(root);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
