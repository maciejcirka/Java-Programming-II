
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Warehouse {
    
    private Map<String, Integer> productsPrice;
    private Map<String, Integer> productsStock;
    
    public Warehouse() {
        
        productsPrice = new HashMap<>();
        productsStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        
        productsPrice.put(product, price);
        productsStock.put(product, stock);
    }
    
    public int price(String product) {
        
        if (!(productsPrice.containsKey(product))) {
            return -99;
        } else {
            return productsPrice.get(product);
        } 
    }
    
    public int stock(String product) {
        
        if (!(productsPrice.containsKey(product))) {
            return 0;
        } else {
            return productsStock.get(product);
        }
    }
    
    public boolean take(String product) {
        if (productsStock.containsKey(product) && productsStock.get(product) > 0 ) {
            productsStock.put(product, productsStock.get(product)-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        
        return productsStock.keySet();
    }
    
}
