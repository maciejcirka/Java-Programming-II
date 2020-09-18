/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Hideout<T> {

    private T object;

    public Hideout() {
        this.object = object;
    }

    public void putIntoHideout(T toHide) {
        this.object = toHide;
    }

    public T takeFromHideout() {
        T taken = object;
        this.object = null;

        return taken;
    }

    public boolean isInHideout() {
        if (this.object == null) {
            return false;
        }

        return true;
    }

}
