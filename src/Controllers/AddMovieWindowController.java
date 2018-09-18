package Controllers;

import Main.MainWindow;
import domain.AgeRating;
import domain.Movie;
import domain.MovieScheduledFactory;
import domain.TypeMovie;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;

import java.io.File;

public class AddMovieWindowController implements IController {
    @FXML
    private Label actionTarget;
    @FXML
    private TextField titleInput;

    public String getDirectorInput() {
        return directorInput.getText();
    }

    public String getTitleInput() {
        return titleInput.getText();
    }

    public String getDurationInput() {
        return durationInput.getText();
    }

    public String getDescriptionInput() {
        return descriptionInput.getText();
    }

    @FXML
    private TextField durationInput;
    @FXML
    private TextArea descriptionInput;
    @FXML
    private TextField directorInput;
    @FXML
    private ChoiceBox typeChoice;
    @FXML
    private ChoiceBox ageChoice;
    @FXML
    private ImageView posterImageView;

    private String picturePath;

    @FXML
    public void initialize() {
        typeChoice.setItems(FXCollections.observableArrayList("Animation", "Action", "Horror", "Comedy", "Drama"));
        ageChoice.setItems(FXCollections.observableArrayList("G", "PG", "PG_13", "R", "NC_17"));
    }

    @FXML
    public void handleChangePosterButtonAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png",
                "*.jpeg");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(((Button) actionEvent.getTarget()).getScene().getWindow());
        System.out.println(file);

        if (file == null) { // cancel
        } else {    // Chosen
            // Example :: D:\Study\Modern Programming practice\groupProject\CinemaTicketBooking\src\Main\Views\HO00000507.jpg
            picturePath = file.toURI().toString();
            Image posterImage = new Image(picturePath);
            posterImageView.setImage(posterImage);
        }
    }

    public void handleSaveButtonAction(ActionEvent actionEvent) {
        try {
            RuleSet rules = RuleSetFactory.getRuleSet(AddMovieWindowController.this);
            rules.applyRules(AddMovieWindowController.this);

            String name = this.titleInput.getText();
            TypeMovie type = TypeMovie.valueOf(((String) this.typeChoice.getValue()).toUpperCase());
            int duringTime = Integer.parseInt(this.durationInput.getText());
            String director = this.directorInput.getText();
            AgeRating rate = AgeRating.valueOf((String) this.ageChoice.getValue());
            String description = this.descriptionInput.getText();

            Movie movie = MovieScheduledFactory.createMovie(0, name, type, duringTime, director, rate, description, picturePath);
            movie.save();

            MainWindow.changeScene("Main");
        } catch (RuleException e) {
            actionTarget.setText(e.getMessage());
        }
    }

    @Override
    public void setData(String key, Object value) {

    }
}
