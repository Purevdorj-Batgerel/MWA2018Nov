package Main;

import Controllers.IController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

public class ScreenController {
    private HashMap<String, String> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    protected void addScreen(String name, String pane) {
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name) {
        screenMap.remove(name);
    }

    protected void activate(String name) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(screenMap.get(name)));
            main.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void activate(String name, String key, Object value) {
        main.getProperties().put(key, value);
        System.out.println("SET " + main);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(screenMap.get(name)));
            Parent root = loader.load();
            IController controller = loader.getController();
            controller.setData(key, value);
            main.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
