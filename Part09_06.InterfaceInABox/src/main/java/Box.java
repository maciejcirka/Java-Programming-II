
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Box implements Packable {
    
    private double capacity;
    private ArrayList<Packable> items;
    

    public Box(double capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        
        
    }
    
    public void add(Packable item) {
        
        if (this.capacity-this.weight()>= item.weight()) {
            items.add(item);
        }
    }
    
    @Override
    public double weight() {
        double weight = 0; 
        
        for(Packable x: items) {
            weight+=x.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + this.weight() + " kg";
    }
    
    
    
    
    
}
