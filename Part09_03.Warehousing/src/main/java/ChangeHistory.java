
import static java.lang.Double.MAX_VALUE;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maciejcirka
 */
public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        history = new ArrayList<>();
    }
    
    ;
    
    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }

        return Collections.max(history);
    }

    public double minValue() {

        if (history.isEmpty()) {
            return 0;
        }
        return Collections.min(history);
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double ave = 0;
        

        for (Double numer : history) {
            ave += numer;
        }

        return (ave / history.size());

    }
    
    @Override
    public String toString() {
        return history.toString();
    }

}
