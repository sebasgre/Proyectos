package Programacion4.Practico10.diccionario;

class Nodo<TKEY, TVALUE> {

    private TKEY key;
    private TVALUE value;
    private Nodo<TKEY, TVALUE> siguiente;
    private Nodo<TKEY, TVALUE> anterior;

    public Nodo(TKEY key, TVALUE value) {
        this.key = key;
        this.value = value;
    }

    public TKEY getKey() {
        return key;
    }

    public void setKey(TKEY key) {
        this.key = key;
    }

    public TVALUE getValue() {
        return value;
    }

    public void setValue(TVALUE value) {
        this.value = value;
    }

    public Nodo<TKEY, TVALUE> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<TKEY, TVALUE> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<TKEY, TVALUE> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<TKEY, TVALUE> anterior) {
        this.anterior = anterior;
    }
}
