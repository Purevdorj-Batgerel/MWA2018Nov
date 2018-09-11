package Controllers;

import Main.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginWindowController {
    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {
        if(checkValid()) {
            MainWindow.changeScene("Main");
        }

    }

    private boolean checkValid() {
        return true;
    }
}
