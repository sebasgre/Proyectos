package Programacion4.Grafos.grafoconpeso;

import java.util.List;

import Programacion4.Grafos.diccionario.Comparador;
import Programacion4.Grafos.diccionario.Diccionario;
import Programacion4.Grafos.diccionario.DiccionarioTablaHash;

public class Nodo<K, V, C extends Number>{

    private K key;
    private V value;
    private C costo;

    public C getCosto() {
        return costo;
    }

    public void setCosto(C costo) {
        this.costo = costo;
    }

    private Diccionario<K, Arista<K, V, C>> aristas;

    public Nodo(K key, V value, C costo, Comparador<K> comparador) {
        this.key = key;
        this.value = value;
        this.costo = costo;
        aristas = new DiccionarioTablaHash<>(comparador);
    }


    public void insertarArista(Nodo<K, V, C> verticeDestino, C costo){
        Arista<K, V, C> aristaDestino = new Arista<>(verticeDestino, costo);
        aristas.insertar(verticeDestino.getKey(), aristaDestino);
    }

    public void eliminarArista(K key){
        aristas.eliminar(key);
    }

    public C getCostoArista(K key){
        if(!aristas.contineLlave(key))
            throw new IllegalArgumentException("La arista no existe");
        Arista<K, V, C> arista = aristas.obtener(key);
        return arista.getCosto();
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public String toString(){
        StringBuilder str = new StringBuilder("(");
        str.append(key).append(",").append(value).append(") => [");
        List<Arista<K, V, C>> listAristas = aristas.getValores();
        String separador = "";
        for (Arista<K, V, C> arista : listAristas) {
            str.append(separador).append(arista.getDestino().getKey());
            str.append(":").append(arista.getCosto());
            separador = ", ";
        }
        str.append("]");
        return str.toString();
    }
}
