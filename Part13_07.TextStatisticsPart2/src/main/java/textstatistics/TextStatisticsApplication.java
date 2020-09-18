package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();

        HBox texts = new HBox();
        texts.setSpacing(10);
        Label first = new Label("Letters: 0");
        Label second = new Label("Words: 0");
        Label third = new Label("The longest word is: ");
        
        texts.getChildren().add(first);
        texts.getChildren().add(second);
        texts.getChildren().add(third);

        TextArea textarea = new TextArea("");

        textarea.textProperty().addListener((change, oldValue, newValue) -> {
            
            int letters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            first.setText("Letters: " + letters);
            second.setText("Words: " + words);
            third.setText("The longest word is: " + longest);

        });

        layout.setCenter(textarea);
        layout.setBottom(texts);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();

    }

}
