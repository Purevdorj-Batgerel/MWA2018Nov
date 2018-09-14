package Controllers;

import Main.MainWindow;
import dataAccess.DBFactory;
import domain.Hall;
import domain.Movie;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddScheduleWindowController {
    @FXML
    private ChoiceBox movieChoice;
    @FXML
    private ChoiceBox hallChoice;
    @FXML
    private DatePicker dateChoice;
    @FXML
    private TextField timeInput;

    @FXML
    public void initialize() {
        movieChoice.setItems(FXCollections.observableArrayList(DBFactory.getMovieList()));
        hallChoice.setItems(FXCollections.observableArrayList(DBFactory.getHallList()));
    }

    @FXML
    public void addSchedule(ActionEvent actionEvent) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(dateChoice.getValue() + " " + timeInput.getText(),
                formatter);

        Movie movie = (Movie) movieChoice.getValue();
        Hall hall = (Hall) hallChoice.getValue();

        if (DBFactory.addSchedule(movie, hall, formatDateTime)) {
            MainWindow.changeScene("Main");
        } else {
            System.out.println("fail");
        }
    }
}
