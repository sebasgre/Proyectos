package Java.demo.src.main.java.Programacion3.Lista;

public class Contenedor {
    private Object contenido;
    private Contenedor siguiente;

    public Contenedor(Object o) {
        contenido = o;
        siguiente = null;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public Contenedor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Contenedor siguiente) {
        this.siguiente = siguiente;
    }
}
