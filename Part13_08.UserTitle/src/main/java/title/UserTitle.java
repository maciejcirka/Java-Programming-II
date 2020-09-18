package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UserTitle extends Application {

    @Override
    public void start(Stage stage)  {
        
        Parameters param = getParameters();
        String title = param.getNamed().get("title");
 
        stage.setTitle(title);
        stage.show();
        
    }


}
