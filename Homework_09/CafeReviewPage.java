//I worked on the homework assignment alone,
//using only course materials

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * Cafe 1331 Reviews UI.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-9-04
 */
public class CafeReviewPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        int[] count = {0};
        String[] colorNames = {"BLACK", "BLUE", "YELLOW", "GREEN",
                               "PURPLE", "ORANGE", "RED", "VIOLET",
                               "BROWN", "PINK", "CHOCOLATE", "AQUA",
                               "FUCHSIA", "INDIGO", "LIMEGREEN", "SLATEGREY"};

        BorderPane pane = new BorderPane();
        pane.setPrefSize(600, 450);

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));

        Label review = new Label();
        GridPane reviewDisplay = new GridPane();
        ScrollPane scrollPane = new ScrollPane(reviewDisplay);

        TextField name = new TextField();
        name.setPromptText("Name");
        name.setAlignment(Pos.BOTTOM_LEFT);

        TextField feedback = new TextField();
        feedback.setPromptText("Feedback");
        feedback.setAlignment(Pos.BOTTOM_LEFT);

        ComboBox<String> cbo = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(colorNames);
        cbo.getItems().addAll(items);
        cbo.getSelectionModel().select(0);
        pane.setTop(cbo);

        Button postButton = new Button("Post");

        hBox.getChildren().add(name);
        hBox.getChildren().add(feedback);
        hBox.getChildren().add(cbo);
        hBox.getChildren().add(postButton);

        HBox.setHgrow(name, Priority.ALWAYS);
        HBox.setHgrow(feedback, Priority.ALWAYS);
        HBox.setHgrow(cbo, Priority.ALWAYS);
        HBox.setHgrow(postButton, Priority.ALWAYS);

        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.vvalueProperty().bind(reviewDisplay.heightProperty());

        postButton.setOnAction(e -> {
            Text text = new Text();
            text.setFont(new Font("SansSerif", 16));

            if (!feedback.getText().equals("")) {
                String response = "";
                if (name.getText().equals("")) {
                    response += "Anonymous:\n";
                } else {
                    response += name.getText() + ":\n";
                }

                if (feedback.getText().equals("")) {
                    response += "Loved the food!\n";
                } else {
                    response += feedback.getText() + "\n";
                }

                text.setStyle("-fx-fill: " + cbo.getValue());
                text.setText(response);

                name.setText("");
                feedback.setText("");
                cbo.getSelectionModel().select(0);

                reviewDisplay.add(text, 1, count[0]);
                count[0] += 3;
            }
        });

        pane.setOnKeyPressed(e -> {
            Text text = new Text();
            text.setFont(new Font("SansSerif", 16));

            if (e.getCode() == KeyCode.ENTER) {
                String response = "";
                if (name.getText().equals("")) {
                    response += "Anonymous:\n";
                } else {
                    response += name.getText() + ":\n";
                }

                if (feedback.getText().equals("")) {
                    response += "Loved the food!\n";
                } else {
                    response += feedback.getText() + "\n";
                }

                text.setStyle("-fx-fill: " + cbo.getValue());
                text.setText(response);

                name.setText("");
                feedback.setText("");
                cbo.getSelectionModel().select(0);

                reviewDisplay.add(text, 1, count[0]);
                count[0] += 3;
            }
        });

        pane.setCenter(scrollPane);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Cafe 1331 Reviews"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * This is the main method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        launch(args);
    }
}