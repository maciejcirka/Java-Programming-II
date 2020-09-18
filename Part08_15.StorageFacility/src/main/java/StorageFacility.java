
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility() {
        
        storage = new HashMap<>();
        
    }
    
    public void add(String unit, String item) {
        
        storage.putIfAbsent(unit, new ArrayList<String>());
        
        storage.get(unit).add(item);
        
    }
    
    public ArrayList<String> contents(String storageUnit) {
        
        if (storage.keySet().contains(storageUnit)) {
            return storage.get(storageUnit);   
        }
        
            return new ArrayList<String>();
    }
    
    public void remove(String storageUnit, String item) {
        storage.get(storageUnit).remove(item);
        if (storage.get(storageUnit).isEmpty()) {
            storage.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        
        ArrayList<String> list = new ArrayList<>();
        
        for (String x: storage.keySet()) {
            if (!(x.isEmpty())) {
                list.add(x);
            }
        }
        
        return list;
    }
    
}
