package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
       launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) {
        
        Button button = new Button("Button");
        TextField tf = new TextField("TextField");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(button);
        components.getChildren().add(tf);
        
        Scene scene = new Scene(components);
        stage.setScene(scene);
        stage.show();
        
        
    }

}
