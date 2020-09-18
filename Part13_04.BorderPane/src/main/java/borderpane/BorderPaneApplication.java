package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage stage) {
        
        BorderPane components = new BorderPane();
        
        components.setTop(new Label("NORTH"));
        components.setRight(new Label("EAST"));
        components.setBottom(new Label("SOUTH"));
        
        
        Scene scene = new Scene(components);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    

}
