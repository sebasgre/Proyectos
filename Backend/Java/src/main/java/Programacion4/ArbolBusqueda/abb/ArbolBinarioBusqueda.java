package Programacion4.ArbolBusqueda.abb;

import java.util.*;

public class ArbolBinarioBusqueda<E> {

    private Nodo<E> raiz;
    private Comparator<E> comparator;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public ArbolBinarioBusqueda(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    public boolean buscar(E obj){
        return buscar(obj, raiz);
    }

    public boolean buscar(E obj, Nodo<E> rsa) {
        if (rsa == null)
            return false;
        final int comparacion = comparar(obj, rsa.getDato());
        if (comparacion == 0) {
            return true;
        } else if (comparacion > 0) {
            return buscar(obj, rsa.getDerecho());
        } else {
            return buscar(obj, rsa.getIzquierdo());
        }
    }

    public void insertar(E... objects) {
        for (E obj : objects) {
            insertar(obj);
        }
    }

    public void insertar(E obj) {
        raiz = insertar(obj, raiz);
    }

    private Nodo<E> insertar(E obj, Nodo<E> rsa) {
        // cuando la referencia es nula se inserta, se le asigna un nodo
        if (rsa == null) {
            rsa = new Nodo<>(obj);
        } else {
            int comparacion = comparar(obj, rsa.getDato());
            if (comparacion > 0) { // si obj > rsa.getDato()
                Nodo<E> nuevo = insertar(obj, rsa.getDerecho());
                rsa.setDerecho(nuevo);
            } else if (comparacion < 0) { // si obj < rsa.getDato()
                Nodo<E> nuevo = insertar(obj, rsa.getIzquierdo());
                rsa.setIzquierdo(nuevo);
            }
        }
        return rsa;
    }

    public void eliminar(E... objects){
        for(E obj : objects){
            eliminar(obj);
        }
    }

    public void eliminar(E obj) {
        raiz = eliminar(obj, raiz);
    }

    private Nodo<E> eliminar(E obj, Nodo<E> rsa) {
        if (rsa == null)
            return rsa;

        final int comparacion = comparar(obj, rsa.getDato());
        if (comparacion == 0) { // obj == rsa.getDato()
            // aqui encontramos el que queremos eliminar
            if (esHoja(rsa)) {
                // 1. es hoja
                rsa = null;
            } else if (rsa.getIzquierdo() != null && rsa.getDerecho() == null) {
                // 2. No es hoja y solo tiene el hijo izquierdo pero no el derecho
                rsa = rsa.getIzquierdo();
            } else if (rsa.getDerecho() != null && rsa.getIzquierdo() == null) {
                // 3. No es hoja y solo tiene el hijo derecho pero no el izquierdo
                rsa = rsa.getDerecho();
            } else {
                // 4. Se tienen los dos hijos

                // Obtengo el mayor del Sub arbol izquierdo
                E mayor = getMayor(rsa.getIzquierdo());
                // Reemplazamos el valor de la Raiz del subarbol
                rsa.setDato(mayor);

                // Mandamos a eliminar el "mayor" a partir del SAI
                Nodo<E> nodo = eliminar(mayor, rsa.getIzquierdo());
                rsa.setIzquierdo(nodo);
            }

        } else if (comparacion > 0) { // si obj > rsa.getDato()
            Nodo<E> nodo = eliminar(obj, rsa.getDerecho());
            rsa.setDerecho(nodo);
        } else if (comparacion < 0) { // si obj < rsa.getDato()
            Nodo<E> nodo = eliminar(obj, rsa.getIzquierdo());
            rsa.setIzquierdo(nodo);
        }

        return rsa;
    }

    public List<E> getRecorridoInOrden() {
        // izquierda - raiz - derecha
        List<E> list = new ArrayList<>();
        recorridoInOrden(raiz, list);
        return list;
    }

    private void recorridoInOrden(Nodo<E> rsa, List<E> list) {
        if (rsa == null) {
            return;
        }

        recorridoInOrden(rsa.getIzquierdo(), list);
        list.add(rsa.getDato());
        recorridoInOrden(rsa.getDerecho(), list);
    }

    public List<E> getRecorridoPreOrden() {
        // raiz - izquierda - derecha
        List<E> list = new ArrayList<>();
        recorridoPreOrden(raiz, list);
        return list;
    }

    private void recorridoPreOrden(Nodo<E> rsa, List<E> list) {
        if (rsa == null) {
            return;
        }

        list.add(rsa.getDato());
        recorridoPreOrden(rsa.getIzquierdo(), list);
        recorridoPreOrden(rsa.getDerecho(), list);
    }

    public List<E> getRecorridoPostOrden() {
        // izquierda - derecha - raiz
        List<E> list = new ArrayList<>();
        getRecorridoPostOrden(raiz, list);
        return list;
    }

    private void getRecorridoPostOrden(Nodo<E> rsa, List<E> list) {
        if (rsa == null) {
            return;
        }

        getRecorridoPostOrden(rsa.getIzquierdo(), list);
        getRecorridoPostOrden(rsa.getDerecho(), list);
        list.add(rsa.getDato());
    }

    public List<E> getRecorridoPorNiveles() {
        // izquierda - derechar por cada nivel
        List<E> recorrido = new ArrayList<>();
        if (raiz != null) {
            Queue<Nodo<E>> tocaVisitar = new LinkedList<>();
            tocaVisitar.add(raiz);
            recorridoPorNiveles(recorrido, tocaVisitar);
        }
        return recorrido;
    }

    private void recorridoPorNiveles(List<E> recorrido, Queue<Nodo<E>> tocaVisitar) {

        if(tocaVisitar.isEmpty())
            return;

        Nodo<E> nodo = tocaVisitar.poll();
        recorrido.add(nodo.getDato());

        if(nodo.getIzquierdo() != null)
            tocaVisitar.add(nodo.getIzquierdo());
        if(nodo.getDerecho() != null)
            tocaVisitar.add(nodo.getDerecho());

        recorridoPorNiveles(recorrido, tocaVisitar);
    }

    public int getPeso(){
        return getPeso(raiz);
    }

    private int getPeso(Nodo<E> rsa) {
        if (rsa == null)
            return 0;
        return 1 + getPeso(rsa.getIzquierdo()) + getPeso(rsa.getDerecho());
    }

    public int getAltura(){
        return getAltura(raiz);
    }

    private int getAltura(Nodo<E> rsa) {
        if (rsa == null)
            return 0;
        int alturaSI = getAltura(rsa.getIzquierdo());
        int alturaSD = getAltura(rsa.getDerecho());
        return 1 + Math.max(alturaSI, alturaSD);
    }

    public List<E> getRamaMasLarga(){
        List<E> recorrido = new ArrayList<>();
        getRamaMasLarga(raiz, recorrido);
        return recorrido;
    }

    private void getRamaMasLarga(Nodo<E> rsa, List<E> recorrido) {
        if (rsa == null)
            return;
        recorrido.add(rsa.getDato());
        int alturaSI = getAltura(rsa.getIzquierdo());
        int alturaSD = getAltura(rsa.getDerecho());
        if(alturaSI > alturaSD)
            getRamaMasLarga(rsa.getIzquierdo(), recorrido);
        else
            getRamaMasLarga(rsa.getDerecho(), recorrido);
    }

    public int comparar(E obj1, E obj2) {
        // asumo que no son nulos
        // comparo 2 objetos
        if (comparator != null) {
            // retorno el resultado de comparar el obj1 y 2
            return comparator.compare(obj1, obj2);
        }
        // si no me pasan un comparador, verifico que el obj 1 sea instancia de
        // comparabl
        if (obj1 instanceof Comparable && obj2 instanceof Comparable) {
            return ((Comparable) obj1).compareTo(obj2);
        }
        // si no funciona
        throw new IllegalArgumentException("Los objetos no pueden ser comparados");
    }

    // si utilizo este metodo no haria falta hacer las validaciones de comparar
    private boolean canCompare(E obj) {
        // verifico si tengo comparador o si el objeto es comparable
        return comparator != null || obj instanceof Comparable;
    }

    private boolean esHoja(Nodo<E> nodo) {
        return nodo.getIzquierdo() == null && nodo.getDerecho() == null;
    }

    private E getMayor(Nodo<E> rsa) {
        if (rsa.getDerecho() == null) {
            return rsa.getDato();
        }
        return getMayor(rsa.getDerecho());
    }

    private E getMenor(Nodo<E> rsa) {
        if (rsa.getIzquierdo() == null) {
            return rsa.getDato();
        }
        return getMayor(rsa.getIzquierdo());
    }

        /*
Algoritmo de Euclides
Codificación Huffman
Algoritmo KMP
Cola de Prioridad a través de un montículo binario
Algoritmos de Hashing para tablas hash
Mocks para Unit Tests
Problema de subsecuencia común más larga
Algoritmo de Casco convexo
Longitud del sub-arreglo más grande con elementos contiguos


     */
}
