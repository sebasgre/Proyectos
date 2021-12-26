package Programacion4.Grafos.grafo;

import java.util.List;

import Programacion4.Grafos.diccionario.Comparador;
import Programacion4.Grafos.diccionario.Diccionario;
import Programacion4.Grafos.diccionario.DiccionarioTablaHash;

class Nodo<K, V> {

    private K key;
    private V value;

    private Diccionario<K, Nodo<K, V>> aristas;

    public Nodo(K key, V value, Comparador<K> comparador) {
        this.key = key;
        this.value = value;
        aristas = new DiccionarioTablaHash<>(comparador);
    }

    public void insertarArista(Nodo<K, V> vertice){
        aristas.insertar(vertice.getKey(), vertice);
    }

    public void eliminarArista(K key){
        aristas.eliminar(key);
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
        List<K> idAristas = aristas.getLlaves();
        String separador = "";
        for (K id : idAristas) {
            str.append(separador).append(id);
            separador = ", ";
        }
        str.append("]");
        return str.toString();
    }

}
