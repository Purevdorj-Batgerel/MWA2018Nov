package Controllers;

import Main.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginWindowController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {
        if (checkValid()) {
            MainWindow.changeScene("Main");
        }

    }

    private boolean checkValid() {
//        username.getText()
//        password.getText()
        return true;
    }
}
