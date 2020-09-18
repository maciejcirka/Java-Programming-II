package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    
    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
    
    @Override
    public void start(Stage window) {
    
    TextField up = new TextField();
    Label down = new Label();
    Button button = new Button("Update");

    button.setOnAction((event) -> {
        down.setText(up.getText());
    });

    VBox componentGroup = new VBox();
    componentGroup.getChildren().addAll(up, button, down);

    Scene scene = new Scene(componentGroup);

    window.setScene(scene);
    window.show();
    

}
}
