
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Herd implements Movable {

    private List<Movable> list;
    
    public Herd() {
        list = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String text ="";
        for(Movable herd: list) {
            text+=herd;
            text+= "\n";
             
        }
        return text;
    }
    
    public void addToHerd(Movable movable) {
        list.add(movable);  
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable herd: list) {
            herd.move(dx, dy);
        }
    }
    
    
    
}
