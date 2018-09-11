import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainWindowController {
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        MainWindow.changeScene("Login");
    }
}
