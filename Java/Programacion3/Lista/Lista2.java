package Lista;

public class Lista2<T> {
    private Contenedor<T> raiz;
    private int tamano;

    public Lista2() {
        raiz = null;
        tamano = 0;
    }

    public Contenedor<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Contenedor<T> raiz) {
        this.raiz = raiz;
    }

    public void insertar(T o) {
        Contenedor<T> nuevo = new Contenedor<>(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
        tamano++;
    }

    public int getTamano() {
        return tamano;
    }

    public void add(T o) {
        if (raiz == null) {
            insertar(o);
            return;
        }

        Contenedor<T> actual = raiz;
        Contenedor<T> nuevo = new Contenedor<>(o);
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        // Aqui tenemos al ultimo
        actual.setSiguiente(nuevo);
        tamano++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Contenedor<T> actual = raiz;
        while (actual != null) {
            sb.append("[").append(actual.getContenido().toString()).append("]---");
            actual = actual.getSiguiente();
        }

        return sb.toString();
    }

    class Contenedor<T> {
        private T contenido;
        private Contenedor<T> siguiente;

        public Contenedor(T c) {
            contenido = c;
            siguiente = null;
        }

        public T getContenido() {
            return contenido;
        }

        public void setContenido(T contenido) {
            this.contenido = contenido;
        }

        public Contenedor<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Contenedor<T> siguiente) {
            this.siguiente = siguiente;
        }
    }
}
