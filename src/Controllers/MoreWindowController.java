package Controllers;

import Main.MainWindow;
import dataAccess.DBFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Map;

public class MoreWindowController implements IController {
    @FXML
    public VBox rootLayout;
    @FXML
    private ImageView posterImageView;
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

    public void handleBackAction(ActionEvent actionEvent) {
        MainWindow.changeScene("Main");
    }

    @Override
    public void setData(String key, Object value) {
        //search database key value
        System.out.println(key + value);
        Map<String, Object> movieInfo = DBFactory.getMovieData((Integer) value);
        titleLabel.setText((String) movieInfo.get("name"));
        typeLabel.setText((String) movieInfo.get("type"));
        durationLabel.setText((Integer) movieInfo.get("duringtime") + " min");
        descriptionLabel.setText((String) movieInfo.get("description"));
        directorLabel.setText((String) movieInfo.get("director"));
        ageRatingLabel.setText((String) movieInfo.get("rate"));


        Image posterImage = new Image((String) movieInfo.get("picture"));
        posterImageView.setImage(posterImage);
    }
}
