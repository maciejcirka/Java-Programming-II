/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Book {
    
    private String title;
    private int age;

    public Book(String title, int age) {
        this.title = title;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return title + " (recommended for " + age + " years-olds or older)";
    }
    
    
    
}
