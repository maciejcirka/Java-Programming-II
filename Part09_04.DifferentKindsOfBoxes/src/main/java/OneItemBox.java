
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
public class OneItemBox extends Box {
    
    private ArrayList<Item> list;
    
    public OneItemBox() {
        
       list = new ArrayList<>();
        
    }
    

    @Override
    public void add(Item item) {
       if( list.isEmpty() ) {
           list.add(item);
       }
    }

    @Override
    public boolean isInBox(Item item) {
        if (list.contains(item)) {
            return true;
        }
        return false;
    }
    
    
    
}
