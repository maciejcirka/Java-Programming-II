/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author maciejcirka
 */
public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }

    public Parent getView() {

        GridPane layout = new GridPane();

        Label instructionLabel = new Label("Translate the word '" + word + "'");
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label feedback = new Label("");

        layout.add(instructionLabel, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);
        
        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(300, 180);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setHgap(10);
        layout.setVgap(10);
        

        checkButton.setOnAction((event) -> {
            if (dictionary.getTranslation(word).equals(translationField.getText())) {
                feedback.setText("Correct!");
                

            } else {
                feedback.setText("Incorrect!");
                return;
            }
            
            this.word = dictionary.getRandomWord();
            instructionLabel.setText("Translate the word '" + this.word + "'");
            translationField.clear();
        });
        
        return layout;
    }

}
