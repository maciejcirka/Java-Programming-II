package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage stage) {
        
        BorderPane layoutBP = new  BorderPane();
        Label label1 = new Label("First view!");
        Button button1 = new Button("To the second view!");
        layoutBP.setTop(label1);
        layoutBP.setCenter(button1);
        
        Scene scene1 = new Scene(layoutBP);
        
        
        VBox components = new VBox();
        Label label2 = new Label("Second view!");
        Button button2 = new Button("To the third view!");
        components.getChildren().setAll(button2, label2);
        
        Scene scene2 = new Scene(components);
        
        
        GridPane layoutGP = new GridPane(); 
        Label label3 = new Label("Third view!");
        Button button3 = new Button("To the first view!");
        layoutGP.add(label3, 0, 0);
        layoutGP.add(button3, 1, 1);
        
        Scene scene3 = new Scene(layoutGP);
        
        
        button1.setOnAction((event) -> stage.setScene(scene2));
        button2.setOnAction((event) -> stage.setScene(scene3));
        button3.setOnAction((event) -> stage.setScene(scene1));
        
        
        stage.setScene(scene1);
        stage.show();
        
        
    }
    
    
}
