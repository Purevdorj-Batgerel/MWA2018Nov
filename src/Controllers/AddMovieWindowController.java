package Controllers;

import Main.MainWindow;
import dataAccess.DBFactory;
import domain.MovieScheduledFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class AddMovieWindowController {
    @FXML
    private ChoiceBox typeChoice;
    @FXML
    private ChoiceBox ageChoice;
    @FXML
    private ImageView posterImageView;


    @FXML
    public void initialize() {
        typeChoice.setItems(FXCollections.observableArrayList("Animation", "Action", "Horror", "Comedy", "Drama"));
        ageChoice.setItems(FXCollections.observableArrayList("G – General Audiences", "PG – Parental Guidance Suggested", "PG-13 – Parents Strongly Cautioned", "R – Restricted",
                "NC-17 – Adults Only"));
    }

    @FXML
    public void handleChangePosterButtonAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(((Button) actionEvent.getTarget()).getScene().getWindow());
        System.out.println(file);

        if (file == null) {
            //cancel
        } else {
            // Chosen D:\Study\Modern Programming practice\groupProject\CinemaTicketBooking\src\Main\Views\HO00000507.jpg
            Image posterImage = new Image(file.toURI().toString());
            posterImageView.setImage(posterImage);
        }
    }

    public void handleSaveButtonAction(ActionEvent actionEvent) {
        //Save to Database
     //   DBFactory.addMovie(MovieScheduledFactory.createMovie(name, rate, releasedDate, type, duringTime));
        boolean saveSuccess = true;
        if (saveSuccess) {
            MainWindow.changeScene("Main");
        }
    }
}
