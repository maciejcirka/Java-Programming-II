/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.*;
import java.util.HashMap;

/**
 *
 * @author maciejcirka
 */
public class FlightControl {
    
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    public void addAirplane(String ID, int capacity) {
        airplanes.put(ID, new Airplane(ID, capacity));
    }
    
    public void addFlight(String airplane, String departure, String destination) {
        places.putIfAbsent(departure, new Place(departure));
        places.putIfAbsent(destination, new Place(destination));
        
        Flight flight = new Flight(this.airplanes.get(airplane), this.places.get(departure), this.places.get(destination));
        flights.put(flight.toString(), flight);
    }
    
    public void printAirplanes() {
        airplanes.values().stream().forEach(plane -> System.out.println(plane));
    }
    
    public void printFlights() {    
            flights.values().stream().forEach(flight -> System.out.println(flight));
    }
    
    public void printAirplaneDetails(String airplaneID) {
        if (airplanes.containsKey(airplaneID)) {
        System.out.println(airplanes.get(airplaneID));
        } else {
            System.out.println("No airplane with the id " + airplaneID + ".");
        }
    }
   
  
}
