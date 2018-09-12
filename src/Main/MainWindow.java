package Main;

import java.sql.SQLException;

import dataAccess.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    private static ScreenController screenController;

	public static DBConnection Conn = null;
	
    public static void main(String[] args) {
    
	/*	try {
			Conn = new DBConnection();
			Conn.insertIntoTable("Bob","Bush", "1989-11-26", "Bob", "123");
			Conn.insertIntoTable("Ken", "Anna", "1976-03-26", "Ken", "111");
			Conn.selectStaffs();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

        launch(args);
    }

    public static void changeScene(String sceneName) {
        screenController.activate(sceneName);
    }
    public static void changeScene(String sceneName, String key, Object value) {
        screenController.activate(sceneName, key, value);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cinema");

        Parent root = FXMLLoader.load(getClass().getResource("Views/loginWindow.fxml"));

        Scene mainScene = new Scene(root, 900, 600);
        screenController = new ScreenController(mainScene);

        screenController.addScreen("Login", "Views/loginWindow.fxml");
        screenController.addScreen("Main", "Views/mainWindow.fxml");
        screenController.addScreen("AddMovie", "Views/addMovieWindow.fxml");
        screenController.addScreen("More", "Views/moreWindow.fxml");

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
