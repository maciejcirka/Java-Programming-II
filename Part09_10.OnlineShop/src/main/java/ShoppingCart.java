
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class ShoppingCart {
    
    private Map<String, Item> basket;

    public ShoppingCart() {
        
       basket = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (basket.containsKey(product)) {
            basket.get(product).increaseQuantity();
        } else {
        basket.put(product, new Item (product, 1, price));
        }
    }
    
    public int price() {
        int total = 0;
        
        for (Item item: basket.values()) {
             total += item.price();
        }
        return total;
    }
    
    public void print() {
        for (Item item: basket.values()) {
            System.out.println(item);
        }
    }
    
}
