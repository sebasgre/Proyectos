package Programacion4.Practico10.diccionario;

import java.util.ArrayList;
import java.util.List;

public class DiccionarioSecuencia<TKEY, TVALUE> extends Diccionario<TKEY, TVALUE> {

    public Nodo<TKEY, TVALUE> primero;
    public Nodo<TKEY, TVALUE> ultimo;

    public DiccionarioSecuencia(Comparador<TKEY> comparador) {
        super(comparador);
    }

    public DiccionarioSecuencia() {
        super();
    }

    @Override
    public void insertar(TKEY key, TVALUE value) {
        Nodo<TKEY, TVALUE> nodo = getNodo(key);
        if (nodo != null) {
            nodo.setValue(value);
            return;
        }
        nodo = new Nodo<>(key, value);
        if (ultimo == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            nodo.setAnterior(ultimo);
            ultimo = nodo;
        }

        cantidadElementos++;

    }

    @Override
    public TVALUE obtener(TKEY key) {
        Nodo<TKEY, TVALUE> nodo = getNodo(key);
        if (nodo == null)
            throw new IllegalStateException("No existe ese nodo");
        return nodo.getValue();
    }

    @Override
    public TVALUE eliminar(TKEY key) {
        Nodo<TKEY, TVALUE> nodo = getNodo(key);
        if (nodo == null)
            return null;
        TVALUE value = nodo.getValue();
        eliminarNodo(nodo);
        cantidadElementos--;
        return value;
    }

    private void eliminarNodo(Nodo<TKEY, TVALUE> nodo) {
        if (nodo == primero && primero == ultimo) {
            primero = null;
            ultimo = null;
            return;
        }
        if (nodo == primero) {
            Nodo<TKEY, TVALUE> siguiente = nodo.getSiguiente();
            siguiente.setAnterior(null);
            primero.setSiguiente(null);
            primero = siguiente;
            return;
        }

        if (nodo == ultimo) {
            Nodo<TKEY, TVALUE> anterior = nodo.getSiguiente();
            anterior.setSiguiente(null);
            ultimo.setAnterior(null);
            ultimo = anterior;
            return;
        }

        Nodo<TKEY, TVALUE> siguiente = nodo.getSiguiente();
        Nodo<TKEY, TVALUE> anterior = nodo.getSiguiente();
        nodo.setAnterior(null);
        nodo.setSiguiente(null);
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);
    }

    @Override
    public boolean contineLlave(TKEY key) {
        return getNodo(key) != null;
    }

    private Nodo<TKEY, TVALUE> getNodo(TKEY key) {
        Nodo<TKEY, TVALUE> aux = primero;
        while (aux != null) {
            if (comparador.esIgual(aux.getKey(), key)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public List<TKEY> getLlaves() {
        List<TKEY> llaves = new ArrayList<TKEY>();
        Nodo<TKEY, TVALUE>  nodo = primero;
        while(nodo != null) {
            llaves.add(nodo.getKey());
            nodo = nodo.getSiguiente();
        }
        return llaves;
    }

    @Override
    public List<TVALUE> getValores() {
        List<TVALUE> llaves = new ArrayList<TVALUE>();
        Nodo<TKEY, TVALUE>  nodo = primero;
        while(nodo != null) {
            llaves.add(nodo.getValue());
            nodo = nodo.getSiguiente();
        }
        return llaves;
    }


}
