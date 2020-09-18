package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label instructionText = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button startButton = new Button("Start");
        Label errorMessage = new Label("");
        GridPane firstLayout = new GridPane();

        firstLayout.add(instructionText, 0, 0);
        firstLayout.add(textField, 0, 1);
        firstLayout.add(startButton, 0, 2);
        firstLayout.add(errorMessage, 0, 3);

        firstLayout.setPrefSize(300, 180);
        firstLayout.setAlignment(Pos.CENTER);
        firstLayout.setVgap(10);
        firstLayout.setHgap(10);
        firstLayout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene scene1 = new Scene(firstLayout);

        Label welcome = new Label("Welcome");
        StackPane secondLayout = new StackPane();
        secondLayout.getChildren().add(welcome);
        secondLayout.setPrefSize(300, 180);
        secondLayout.setAlignment(Pos.CENTER);

        Scene scene2 = new Scene(secondLayout);

        startButton.setOnAction((event) -> {
            welcome.setText("Welcome " + textField.getText() + "!");
            stage.setScene(scene2);
        });

        stage.setScene(scene1);
        stage.show();

    }

}
