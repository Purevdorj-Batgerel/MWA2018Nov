package Controllers;

import Main.MainWindow;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class MainWindowController {
    @FXML
    private HBox movieHBox;
    @FXML
    private Button addMovieButton;

    @FXML
    public void onMouseEnter(MouseEvent event) {
        TranslateTransition animation = new TranslateTransition(Duration.millis(200), ((StackPane) event.getTarget()).getChildren().get(1));
        animation.setInterpolator(Interpolator.EASE_BOTH);
        animation.setToY(-20f);
        animation.play();
    }

    @FXML
    public void onMouseExit(MouseEvent event) {
        TranslateTransition animation = new TranslateTransition(Duration.millis(200), ((StackPane) event.getTarget()).getChildren().get(1));
        animation.setInterpolator(Interpolator.EASE_BOTH);
        animation.setToY(0f);
        animation.play();
    }

    private void onMouseClick(MouseEvent mouseEvent) {
        int id = (int) ((StackPane) mouseEvent.getTarget()).getProperties().get("id");
        MainWindow.changeScene("More");
    }


    @FXML
    public void initialize() {
        //Check database user
        boolean isUserStaff = true;

        if (!isUserStaff) {
            addMovieButton.setVisible(false);
        }

        //Get Movie details to populate movie list;

        addMovie(156, "Action", "Avengers: Infinity War", "/Main/Views/HO00000490.jpg", 1);
        addMovie(97, "Animation", "Hotel Transylvania 3: Summer Vacation", "/Main/Views/HO00000502.jpg", 2);
        addMovie(147, "Action", "Mission: Impossible - Fallout", "/Main/Views/HO00000504.jpg", 3);
        addMovie(113, "Action", "The Meg", "/Main/Views/HO00000506.jpg", 4);
        addMovie(105, "Animation", "Christopher Robin", "/Main/Views/HO00000507.jpg", 5);

        System.out.println("List Populated");
    }

    public void addMovie(int duration, String type, String title, String posterImageSource, int id) {
        StackPane stackPane = new StackPane();
        stackPane.setMinWidth(220f);
        stackPane.setOnMouseEntered(this::onMouseEnter);
        stackPane.setOnMouseExited(this::onMouseExit);
        stackPane.setOnMouseClicked(this::onMouseClick);
        stackPane.getStyleClass().add("stackPane");

        VBox vBox = new VBox();
        vBox.setPrefHeight(200f);
        vBox.setPrefWidth(100f);
        vBox.setAlignment(Pos.CENTER);

        Pane pane = new Pane();
        pane.setMinHeight(270f);

        VBox infoSection = new VBox();
        infoSection.setAlignment(Pos.CENTER_LEFT);
        infoSection.setFillWidth(false);
        infoSection.setMaxWidth(180f);

        Label durationLabel = new Label("Duration: " + duration + "min");
        VBox.setMargin(durationLabel, new Insets(0, 0, 5, 0));

        Label typeLabel = new Label(type);
        typeLabel.getStyleClass().add("movieType");

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("movieTitle");
        titleLabel.setMaxWidth(200f);
        infoSection.getChildren().addAll(durationLabel, typeLabel, titleLabel);

        vBox.getChildren().addAll(pane, infoSection);

        Image posterImage = new Image(posterImageSource);
        ImageView poster = new ImageView(posterImage);
        poster.setFitHeight(300f);
        poster.setFitWidth(210f);
        poster.setPickOnBounds(true);
        poster.setPreserveRatio(true);
        StackPane.setAlignment(poster, Pos.TOP_CENTER);
        StackPane.setMargin(poster, new Insets(-11, 0, 0, 0));

        stackPane.getChildren().addAll(vBox, poster);
        stackPane.getProperties().put("id", id);
        movieHBox.getChildren().add(stackPane);
    }

    public void handleAddMovieAction(ActionEvent actionEvent) {
        MainWindow.changeScene("AddMovie");
    }
}
