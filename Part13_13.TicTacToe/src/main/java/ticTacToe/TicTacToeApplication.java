package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Player player = new Player(Mark.X);
        BorderPane layout = new BorderPane();
        Label turnLabel = new Label("Turn: X");
        layout.setTop(turnLabel);

        GridPane board = new GridPane();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                Button button = createButton();
                board.add(button, x, y);

                button.setOnAction((event) -> {

                    if (player.isWin() == false) {

                        if (button.getText().equals(" ")) {
                            button.setText(player.putMark());

                            if (checkIfWin(board, player) == true) {
                                turnLabel.setText("The end!");
                                player.won();

                            } else {
                                player.switchPlayer();
                                turnLabel.setText("Turn: " + player.getMark());
                            }

                        }
                    }

                });;

            }

        }

        board.setAlignment(Pos.CENTER);
        layout.setPrefSize(200, 200);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setCenter(board);

        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();

    }

    private Button createButton() {
        Button button = new Button(" ");
        button.setFont(Font.font("Monospaced", 40));

        return button;
    }

    private String getButtonText(GridPane board, int x, int y) {
        return ((Button) board.getChildren().get(x * 3 + y)).getText();
    }

    private boolean checkIfWin(GridPane board, Player player) {

        //check rows
        for (int y = 0; y < 3; y++) {
            int count = 0;
            for (int x = 0; x < 3; x++) {
                if (getButtonText(board, x, y).equals(player.getMark())) {
                    count++;
                }

                if (count == 3) {
                    return true;
                }

            }
        }

        //check columns   
        for (int x = 0; x < 3; x++) {
            int count = 0;
            for (int y = 0; y < 3; y++) {
                if (getButtonText(board, x, y).equals(player.getMark())) {
                    count++;
                }

                if (count == 3) {
                    return true;
                }
            }
        }

        //check diagonals
        for (int i = 0; i < 3; i++) {
            int countOne = 0;
            int countTwo = 0;
            if (getButtonText(board, i, i).equals(player.getMark())) {
                countOne++;
            }

            if (getButtonText(board, 2 - i, i).equals(player.getMark())) {
                countTwo++;
            }

            if (countOne == 3 || countTwo == 3) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
