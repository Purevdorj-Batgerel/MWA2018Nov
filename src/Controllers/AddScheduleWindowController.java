package Controllers;



import dataAccess.DBFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
	    	
	      System.out.println("Add Schedule: "+ movieChoice.getValue() +  " " + hallChoice.getValue() + " " + dateChoice.getValue() + " "+ timeInput.getText());
	    }
	    

}
