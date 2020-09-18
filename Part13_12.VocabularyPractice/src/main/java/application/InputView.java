/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author maciejcirka
 */
public class InputView {

    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {

        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word");
        TextField wordField = new TextField("");
        Label translationLabel = new Label("Translation");
        TextField translationField = new TextField("");
        Button addButton = new Button("Add the word pair");
        
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(10);
        layout.setVgap(10);
        
        layout.add(wordLabel, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(addButton, 0, 4);


        addButton.setOnAction((event) -> {
            
            dictionary.add(wordField.getText(), translationField.getText());

            wordField.clear();
            translationField.clear();

        });

        return layout;

    }
    

}
