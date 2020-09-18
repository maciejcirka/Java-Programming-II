package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        
        HBox menu = new HBox();
        menu.setSpacing(10);
        menu.setPadding(new Insets(20,20,20,20));
        
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        
        menu.getChildren().add(jokeButton);
        menu.getChildren().add(answerButton);
        menu.getChildren().add(explanationButton);
        
        layout.setTop(menu);
        
        
        
        StackPane joke = createView("What do you call a bear with no teeth?");
        StackPane answer = createView("A gummy bear.");
        StackPane explanation = createView("You tell me");
           
        layout.setCenter(joke);
        
        
        
        jokeButton.setOnAction((event) -> layout.setCenter(joke));
        answerButton.setOnAction((event) -> layout.setCenter(answer));
        explanationButton.setOnAction((event) -> layout.setCenter(explanation));
        
        
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    
    }
    
    private StackPane createView(String text) {
        
        StackPane sp = new StackPane();
        sp.setPrefSize(300, 180);
        sp.setAlignment(Pos.CENTER);
        sp.getChildren().add(new Label(text));
        
        return sp;
        
    }
}
