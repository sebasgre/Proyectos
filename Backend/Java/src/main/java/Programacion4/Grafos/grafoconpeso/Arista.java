package Programacion4.Grafos.grafoconpeso;

public class Arista<K, V, C extends Number> {

    private Nodo<K, V, C> destino;
    private C costo;

    public Arista(Nodo<K, V, C> destino, C costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public Nodo<K, V, C> getDestino() {
        return destino;
    }

    public void setDestino(Nodo<K, V, C> destino) {
        this.destino = destino;
    }

    public C getCosto() {
        return costo;
    }

    public void setCosto(C costo) {
        this.costo = costo;
    }
}
