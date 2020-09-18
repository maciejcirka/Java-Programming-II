package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Canvas canvas = new Canvas(400, 400);
        GraphicsContext painter = canvas.getGraphicsContext2D();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(canvas);

        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        painter.setFill(Color.BLACK);
        painter.fillRect(100, 50, 50, 50); // left eye
        painter.fillRect(250, 50, 50, 50); // right eye
        painter.fillRect(50, 200, 50, 50); // left cheek
        painter.fillRect(300, 200, 50, 50); // right cheek
        painter.fillRect(100, 250, 200, 50); // mouth

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.show();

    }

}
