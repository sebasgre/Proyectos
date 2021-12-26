package Programacion4.Practico9;

public class Lista<E> {
    private Nodo<E> primero;
    private Nodo<E> ultimo;
    private int size;

    public Lista() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insertar(E obj) {
        Nodo<E> nuevo = new Nodo<E>(obj);
        if (size == 0) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
            // NODO 1
            //ultimo = siguienteNuevo --> NODO2
            //nuevo = Anterior --> NODO1
            //ultimo = nuevo --> NODO2
        }
        size++;
    }

    public E get(int posicion) {
        Nodo<E> actual = primero;
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("No existe la posicion: " + posicion);
        } else {
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
        }
        return actual.getDato();
    }

    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= size)
            throw new IndexOutOfBoundsException("No existe la posicion: " + posicion);
        else if (posicion == 0) {
            primero = primero.getSiguiente();
            return;
        }

        Nodo<E> buscar = primero;
        for (int i = 0; i < posicion; i++) {
            buscar = buscar.getSiguiente();
        }
        Nodo<E> antes = buscar.getAnterior();
        Nodo<E> despues = buscar.getSiguiente();
        antes.setSiguiente(despues);
        despues.setAnterior(antes);
    }

    public void vaciar() {
        primero = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder();
        StringBuilder separador = new StringBuilder();
        StringBuilder comma = new StringBuilder(", ");

        Nodo<E> actual = primero;
        while (actual != null) {
            lista.append(separador).append(actual.getDato().toString());
            separador = comma;
            actual = actual.getSiguiente();
        }
        return lista.toString();
    }
}
