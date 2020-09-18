/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author maciejcirka
 */
public class TemperatureSensor implements Sensor {
    
    private boolean state;

    public TemperatureSensor() {
        state = false;
    }

    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public void setOn() {
        this.state = true;
    }

    @Override
    public void setOff() {
        this.state = false;
    }

    @Override
    public int read() {
        int number = new Random().nextInt(61)-30;;
        if (this.isOn() == false) {
            throw new IllegalStateException("The temperature sensor is off!");
        }
        return number;
    } 
    
}
