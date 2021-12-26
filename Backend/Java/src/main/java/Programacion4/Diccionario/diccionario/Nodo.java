package Programacion4.Diccionario.diccionario;

class Nodo<TKEY, TVALUE> {

    private TKEY key;
    private TVALUE value;
    private Nodo<TKEY, TVALUE> siguiente;
    private Nodo<TKEY, TVALUE> anterior;

    protected Nodo(TKEY key, TVALUE value) {
        this.key = key;
        this.value = value;
    }

    protected TKEY getKey() {
        return key;
    }

    protected void setKey(TKEY key) {
        this.key = key;
    }

    protected TVALUE getValue() {
        return value;
    }

    protected void setValue(TVALUE value) {
        this.value = value;
    }

    protected Nodo<TKEY, TVALUE> getSiguiente() {
        return siguiente;
    }

    protected void setSiguiente(Nodo<TKEY, TVALUE> siguiente) {
        this.siguiente = siguiente;
    }

    protected Nodo<TKEY, TVALUE> getAnterior() {
        return anterior;
    }

    protected void setAnterior(Nodo<TKEY, TVALUE> anterior) {
        this.anterior = anterior;
    }

    public String toString(){
        return "("+ key.toString() + "," + value.toString()+ ")";
    }
}
