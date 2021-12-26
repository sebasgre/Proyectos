package Programacion4.ArbolAVL.avl;

class Nodo<E> {

    private E dato;
    private Nodo<E> izquierdo;
    private Nodo<E> derecho;
    private int altura;

    public Nodo(E dato) {
        this.dato = dato;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<E> derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
