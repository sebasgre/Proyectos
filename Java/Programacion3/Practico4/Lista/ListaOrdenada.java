package Java.Programacion3.Practico4.Lista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> {
    private final PropertyChangeSupport observed;
    private final static Logger logger = LogManager.getLogger();

    public ListaOrdenada() {
        super();
        this.observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observador) {
        observed.addPropertyChangeListener(observador);
    }

    public void cambioOk() {
        observed.firePropertyChange("Cambio", 1, 2);
    }

    @Override
    public void insertar(T o) {
        logger.debug("Aqui insertamos a las personas en el nodo de forma ordenada");
        if (raiz == null) {
            super.insertar(o);
            return;
        }

        Comparable<T> comparable = (Comparable) o;
        if (comparable.compareTo(raiz.getContenido()) <= 0) {
            super.insertar(o);
            return;
        }

        Contenedor<T> nuevo = new Contenedor<T>(o);
        Contenedor<T> actual = raiz;

        while (actual.getSiguiente() != null &&
                comparable.compareTo(actual.getSiguiente().getContenido()) > 0) {
            actual = actual.getSiguiente();
        }

        // Aqui actual es el nodo anterior al lugar donde debe ir o (nuevo)
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        tamano++;
    }
}
