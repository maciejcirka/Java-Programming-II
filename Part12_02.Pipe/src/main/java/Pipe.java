
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maciejcirka
 */
public class Pipe<T> {

    private ArrayList<T> pipe;

    public Pipe() {
        this.pipe = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        pipe.add(value);
    }

    public T takeFromPipe() {
        if (pipe.isEmpty() == false) {
            T object = pipe.get(0);
            pipe.remove(object);
            return object;
        } else {
            return null;
        }
    }

    public boolean isInPipe() {
        if (pipe.isEmpty()) {
            return false;
        }
        return true;
    }

}
