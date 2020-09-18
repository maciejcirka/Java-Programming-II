/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author maciejcirka
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        sensors = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor: sensors) {
            if (sensor.isOn() != true) {
                return false;
            }
        }
        return true;
    }
  

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }

    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }

    }

    @Override
    public int read() {

        int average = 0;
        if (this.isOn() == true && sensors.isEmpty() == false) {
            double number = sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();
            average = (int) number;
        } else {
            throw new IllegalStateException("No sensor has been added to AverageSensor or it is off!");
        }
        readings.add(average);
        return average;
    }
    
    public List<Integer> readings() {
        return readings;
    }

}
