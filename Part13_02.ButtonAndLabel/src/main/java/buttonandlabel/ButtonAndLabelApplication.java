package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) {
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(new Label("Label"));
        componentGroup.getChildren().add(new Button("Button"));
        
        Scene scene = new Scene(componentGroup);
        
        stage.setScene(scene);
        stage.show();
        
    }

}
