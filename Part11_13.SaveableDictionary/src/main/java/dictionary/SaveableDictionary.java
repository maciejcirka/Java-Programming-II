/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maciejcirka
 */
public class SaveableDictionary {

    private String file;
    private List<Word> dictionary = new ArrayList<>();

    public SaveableDictionary() {
    }

    public SaveableDictionary(String file) {
        this.file = file;
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(new File(this.file));
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean save() {
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            for (Word word : dictionary) {
                fileWriter.write(word.getWord() + ":" + word.getTranslation()+ "\n");
            }
            fileWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    
}

public void add(String words, String translation) {
        if (dictionary.contains(words) == false) {
            dictionary.add(new Word(words, translation));
        }
    }

    public String translate(String word) {

        for (Word x : dictionary) {
            if (x.getWord().equals(word)) {
                return x.getTranslation();
            } else if (x.getTranslation().equals(word)) {
                return x.getWord();
            }
        }
        return null;
    }

    public void delete(String word) {

        Iterator<Word> iterator = dictionary.iterator();

        while (iterator.hasNext()) {
            Word x = iterator.next();
            if (x.getTranslation().equals(word) || x.getWord().equals(word)) {
                iterator.remove();
            }

        }

    }

}
