package Java.Programacion3.Practico1.Modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Linea {
    private int x;
    private int y;
    private int alto;

    private PropertyChangeSupport observed;


    public Linea() {
        x = 0;
        y = 400;
        alto = (int) (Math.random() * 399) + 1;

        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observador) {
        observed.addPropertyChangeListener(observador);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        int oldValue = this.x;
        this.x = x;
        int newValue = this.x;

        observed.firePropertyChange("CAMBIO", oldValue, newValue);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        int oldValue = this.alto;
        this.alto = alto;
        int newValue = this.alto;

        observed.firePropertyChange("CAMBIO", oldValue, newValue);
    }
}
