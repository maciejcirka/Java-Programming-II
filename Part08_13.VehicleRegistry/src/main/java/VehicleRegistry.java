
import java.util.HashMap;
import java.util.HashSet;
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
public class VehicleRegistry {

    private HashMap<LicensePlate, String> owners;
    
    public VehicleRegistry() {
        
        owners = new HashMap<LicensePlate, String>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {

        if (owners.get(licensePlate) == null) {

            owners.put(licensePlate, owner);
            return true;
        }

        return false;

    }

    public String get(LicensePlate licensePlate) {
        
        if (!(owners.containsKey(licensePlate))) {
            return null;
        }

        return owners.get(licensePlate);

    }

    public boolean remove(LicensePlate licensePlate) {

        if (owners.containsKey(licensePlate)) {
            owners.remove(licensePlate);
            return true;
        }
        return false;

    }
    
    public void printLicensePlates() {
        
        for (LicensePlate plate: owners.keySet()) {
            System.out.println(plate);
        }
        
        
    }
    
    public void printOwners() {
        
        Set<String> ownerSet = new HashSet<String>(owners.values());
        
        for (String owner: ownerSet) {
            System.out.println(owner);
        }
        
    }
    
}
