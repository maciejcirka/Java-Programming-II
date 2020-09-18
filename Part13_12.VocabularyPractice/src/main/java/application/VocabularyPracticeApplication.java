package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {

        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {

        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);

        Button newWords = new Button("Enter new words");
        Button practice = new Button("Practice");

        menu.getChildren().addAll(newWords, practice);

        layout.setTop(menu);
        layout.setCenter(inputView.getView());

        newWords.setOnAction((event) -> layout.setCenter(inputView.getView()));
        practice.setOnAction((event) -> layout.setCenter(practiceView.getView()));

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

}
