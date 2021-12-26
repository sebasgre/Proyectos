package Programacion4.Grafos.grafo;

import Programacion4.Grafos.diccionario.ComparadorGenerico;

public class Main {

    public static void main(String[] args) {
        Grafo<String, Integer> grafo = new Grafo<>(new ComparadorGenerico<>());
        grafo.insertarVertice("A", 1);
        grafo.insertarVertice("B", 2);
        grafo.insertarVertice("C", 3);
        grafo.insertarVertice("D", 4);

        grafo.insertarArista("A", "A");
        grafo.insertarArista("A", "B");
        grafo.insertarArista("A", "C");
        grafo.insertarArista("A", "D");

        grafo.insertarArista("B", "A");
        grafo.insertarArista("B", "C");

        grafo.insertarArista("C", "A");
        grafo.insertarArista("C", "B");

        grafo.insertarArista("D", "B");

        System.out.println(grafo);
        System.out.println();

        int eliminado = grafo.eliminarVertice("C");
        System.out.println("Eliminado: " + eliminado);
        System.out.println();

        System.out.println(grafo);
    }
}
