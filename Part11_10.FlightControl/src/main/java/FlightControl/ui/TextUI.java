/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

import FlightControl.logic.*;
import java.util.Scanner;

/**
 *
 * @author maciejcirka
 */
public class TextUI {

    private FlightControl flightcontrol;
    private Scanner scanner;

    public TextUI() {
        flightcontrol = new FlightControl();
        scanner = new Scanner(System.in);
    }

    public void start() {
        airPortAssetControl();
        System.out.println();
        flightAssetControl();
        System.out.println();
    }

    private void airPortAssetControl() {
        
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();
        
        while (true) {
            System.out.println("Choose an action: ");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            
            String input = scanner.nextLine();
            System.out.print("> ");
            
            if (input.equals("1")) {
                askForAirplane();
            } else if (input.equals("2")) {
                askForFlight();
            } else if (input.equals("x")) {
                break;
            }

        }
    }

    private void flightAssetControl() {
        
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action: ");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            
            String input = scanner.nextLine();
            System.out.print("> ");
            
            if (input.equals("1")) {
                flightcontrol.printAirplanes();
            } else if (input.equals("2")) {
                flightcontrol.printFlights();
            } else if (input.equals("3")) {
                System.out.println("Give the airplane id: ");
                flightcontrol.printAirplaneDetails(scanner.nextLine());
            } else if (input.equals("x")) {
                break;

            }
        }
    }

    private void askForAirplane() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println("Give the airplane capacity: ");
        int cap = Integer.parseInt(scanner.nextLine());
        flightcontrol.addAirplane(id, cap);
    }

    private void askForFlight() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println("Give the departure airport id: ");
        String dep = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String tar = scanner.nextLine();
        flightcontrol.addFlight(id, dep, tar);
    }

}
