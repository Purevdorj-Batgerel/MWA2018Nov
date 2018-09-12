package Controllers;

import Main.MainWindow;
import dataAccess.DBFactory;
import domain.AgeRating;
import domain.Movie;
import domain.MovieScheduledFactory;
import domain.TypeMovie;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class AddMovieWindowController {
	@FXML
	private TextField titleInput;
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

		if (file == null) {
			// cancel
		} else {
			// Chosen D:\Study\Modern Programming
			// practice\groupProject\CinemaTicketBooking\src\Main\Views\HO00000507.jpg
			Image posterImage = new Image(file.toURI().toString());
			posterImageView.setImage(posterImage);
		}
	}

	public void handleSaveButtonAction(ActionEvent actionEvent) {
		// Save to Database
		// DBFactory.addMovie(MovieScheduledFactory.createMovie(name, rate,
		// releasedDate, type, duringTime));
		String name = this.titleInput.getText();
		TypeMovie type = TypeMovie.valueOf((String) this.typeChoice.getValue());
		int duringTime = Integer.parseInt(this.durationInput.getText());
		String director = this.directorInput.getText();
		AgeRating rate = AgeRating.valueOf((String) this.ageChoice.getValue());
		String description = this.descriptionInput.getText();
		DBFactory.addMovie(MovieScheduledFactory.createMovie(name, type, duringTime, director, rate, description));
		boolean saveSuccess = true;
		if (saveSuccess) {
			MainWindow.changeScene("Main");
		}
	}
}
