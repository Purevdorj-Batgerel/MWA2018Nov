package Controllers;

import Main.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MoreWindowController {
    @FXML
    public VBox rootLayout;
    @FXML
    private Label titleLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label directorLabel;
    @FXML
    private Label ageRatingLabel;


    @FXML
    public void initialize() {

        System.out.println("GET" + rootLayout.getScene());
    }

    public void hanleBackAction(ActionEvent actionEvent) {
        MainWindow.changeScene("Main");
    }
}
