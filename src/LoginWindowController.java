import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginWindowController {
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        MainWindow.changeScene("Main");
    }
}
