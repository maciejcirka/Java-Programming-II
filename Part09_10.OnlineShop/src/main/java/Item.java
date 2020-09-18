
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
public class Item {
    
    private String product;
    private int qty;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        int price = this.unitPrice;
        int multiply = this.qty;
        
       return price*multiply;
    }
    
    public void increaseQuantity() {
        this.qty+=1; 
    }
    
    @Override
    public String toString() {
        return this.product + ": " + this.qty;
    }
    
}
