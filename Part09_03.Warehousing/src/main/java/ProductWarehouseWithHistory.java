/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    
    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        
        history = new ChangeHistory();
        history.add(initialBalance);
    }
    
    public String history() {
       return history.toString();
    }
    
    @Override
    public void addToWarehouse(double amount) {
       super.addToWarehouse(amount);
       history.add(super.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double prevBalance = this.getBalance();
        super.takeFromWarehouse(amount);
        history.add(this.getBalance());
        return prevBalance - this.getBalance();
    }
    
    public void printAnalysis() {
        
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history);
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
        
    }
}
