package Java.demo.src.main.java.Programacion3.Animacion.Modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Figura {
    private int alto;
    private int ancho;

    private int x;
    private int y;

    private PropertyChangeSupport observed;

    public Figura() {
        x = 0;
        y = 0;
        alto = 50;
        ancho = 50;

        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observador) {
        observed.addPropertyChangeListener(observador);
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
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
}
