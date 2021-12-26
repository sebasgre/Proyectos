package Programacion4.Grafos.grafoconpeso;

import java.util.List;

import Programacion4.Grafos.diccionario.Comparador;
import Programacion4.Grafos.diccionario.Diccionario;
import Programacion4.Grafos.diccionario.DiccionarioTablaHash;

public class GrafoConPeso<K, V, C extends Number> {

    private Comparador<K> comparador;
    private Diccionario<K, Nodo<K, V, C>> vertices;

    public GrafoConPeso(Comparador<K> comparador) {
        this.comparador = comparador;
        this.vertices = new DiccionarioTablaHash<>(comparador);
    }

    public void insertarVertice(K key, V valor, C costo){
        if(vertices.contineLlave(key))
            throw new IllegalArgumentException("Ya existe un vertice con dicha llave");
        Nodo<K, V, C> nodo = new Nodo<>(key, valor, costo, comparador);
        vertices.insertar(key, nodo);
    }

    public V eliminarVertice(K key){
        if(!vertices.contineLlave(key))
            throw new IllegalArgumentException("No existe un vertice con dicha llave");
        List<K> ids = vertices.getLlaves();

        for(K id :ids){
            eliminarArista(id, key);
        }
        Nodo<K,V,C> nodo = vertices.eliminar(key);
        return nodo.getValue();
    }

    public void insertarArista(K origen, K destino, C costo){

        if(!vertices.contineLlave(origen))
            throw new IllegalArgumentException("El origen no existe");
        if(!vertices.contineLlave(destino))
            throw new IllegalArgumentException("El destino no existe");

        Nodo<K, V,C> verticeOrigen = vertices.obtener(origen);
        Nodo<K, V,C> verticeDestino = vertices.obtener(destino);
        verticeOrigen.insertarArista(verticeDestino,costo);
    }

    public void eliminarArista(K origen, K destino) {
        if (!vertices.contineLlave(origen))
            throw new IllegalArgumentException("El origen no existe");
        if (!vertices.contineLlave(destino))
            throw new IllegalArgumentException("El destino no existe");

        Nodo<K, V, C> verticeOrigen = vertices.obtener(origen);
        verticeOrigen.eliminarArista(destino);
    }

    public C getCostoArista(K origen, K destino) {
        if(!vertices.contineLlave(origen))
            throw new IllegalArgumentException("El origen no existe");
        if(!vertices.contineLlave(destino))
            throw new IllegalArgumentException("El destino no existe");
        Nodo<K, V,C> verticeOrigen = vertices.obtener(origen);
        return verticeOrigen.getCostoArista(destino);
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        List<Nodo<K,V, C>> nodos = vertices.getValores();
        String separador = "";
        for (Nodo<K,V, C> nodo : nodos) {
            str.append(separador).append(nodo);
            separador = "\n";
        }
        return str.toString();

    }

}
