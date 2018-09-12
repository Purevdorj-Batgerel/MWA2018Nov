package Main;

import javafx.fxml.FXMLLoader;
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
            main.setRoot(FXMLLoader.load(getClass().getResource(screenMap.get(name))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
