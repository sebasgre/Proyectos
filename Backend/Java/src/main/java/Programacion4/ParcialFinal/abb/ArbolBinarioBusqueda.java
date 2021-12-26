package Programacion4.ParcialFinal.abb;

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

    public boolean buscar(E obj) {
        return buscar(obj, raiz);
    }

    private boolean buscar(E obj, Nodo<E> rsa) {
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

    public void eliminar(E... objects) {
        for (E obj : objects) {
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
        if (comparacion == 0) { //obj == rsa.getDato()
            //Aqui encontramos el que queremos eliminar

            if (esHoja(rsa)) {
                // 1. Es hoja
                rsa = null;
            } else if (rsa.getIzquierdo() != null && rsa.getDerecho() == null) {
                //2. No es hoja y solo tiene el hijo izquierdo pero no el derecho
                rsa = rsa.getIzquierdo();
            } else if (rsa.getDerecho() != null && rsa.getIzquierdo() == null) {
                //3. No es hoja y solo tiene el hijo derecho pero no el izquierdo
                rsa = rsa.getDerecho();
            } else {
                //4. Se tienen los dos hijos

                //Obtengo el mayor del SI
                E mayor = getMayor(rsa.getIzquierdo());
                //Reemplazamos el valor de la RSA
                rsa.setDato(mayor);

                //Mandamos a eliminar el "mayor" a partir del SI
                Nodo<E> nodo = eliminar(mayor, rsa.getIzquierdo());
                rsa.setIzquierdo(nodo);

            }


            /*




             */


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
        List<E> recorrido = new ArrayList<>();
        if (raiz != null) {
            Queue<Nodo<E>> tocaVisitar = new LinkedList<>();
            tocaVisitar.add(raiz);
            recorridoPorNiveles(recorrido, tocaVisitar);
        }
        return recorrido;
    }

    private void recorridoPorNiveles(List<E> recorrido, Queue<Nodo<E>> tocaVisitar) {

        if (tocaVisitar.isEmpty())
            return;

        Nodo<E> nodo = tocaVisitar.poll();
        recorrido.add(nodo.getDato());

        if (nodo.getIzquierdo() != null)
            tocaVisitar.add(nodo.getIzquierdo());
        if (nodo.getDerecho() != null)
            tocaVisitar.add(nodo.getDerecho());

        recorridoPorNiveles(recorrido, tocaVisitar);
    }

    public int getPeso() {
        return getPeso(raiz);
    }

    private int getPeso(Nodo<E> rsa) {
        if (rsa == null)
            return 0;

        return 1 + getPeso(rsa.getIzquierdo()) + getPeso(rsa.getDerecho());
    }

    public int getAltura() {
        return getAltura(raiz);
    }

    private int getAltura(Nodo<E> rsa) {
        if (rsa == null)
            return 0;

        int alturaSI = getAltura(rsa.getIzquierdo());
        int alturaSD = getAltura(rsa.getDerecho());
        return 1 + Math.max(alturaSI, alturaSD);
    }

    public List<E> getRamaMasLarga() {
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
        if (alturaSI > alturaSD)
            getRamaMasLarga(rsa.getIzquierdo(), recorrido);
        else
            getRamaMasLarga(rsa.getDerecho(), recorrido);
    }


    private int comparar(E obj1, E obj2) {
        if (comparator != null) {
            return comparator.compare(obj1, obj2);
        }
        if (obj1 instanceof Comparable && obj2 instanceof Comparable) {
            return ((Comparable) obj1).compareTo(obj2);
        }
        throw new IllegalArgumentException("Los objetos no pueden ser comparados");
    }

    private boolean canCompare(E obj) {
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


    public E getAncestroComun(E objA, E objB) {
        E result = null;
        if (objA == null || objB == null)
            throw new IllegalArgumentException("Los valores ingresados no pueden ser nulos");
        if (raiz != null) {
            if (buscar(objA) && buscar(objB)) {
                Nodo<E> valueA = new Nodo<>(objA);
                Nodo<E> valueB = new Nodo<>(objB);
//                int comparacion = comparar(objB, objA);
//                if (comparacion > 0) {
//                    getAncestroComun(valueB.getDato(), raiz.getDerecho().getDato());
//                    raiz.setDerecho(raiz.getDerecho());
//                } else if (comparacion < 0) {
//                    getAncestroComun(valueA.getDato(), raiz.getIzquierdo().getDato());
//                    raiz.setIzquierdo(raiz.getIzquierdo());
//                }
                if (Integer.parseInt(String.valueOf(valueA.getDato())) <= Integer.parseInt(String.valueOf(raiz.getDato()))
                    && Integer.parseInt(String.valueOf(valueB.getDato())) >= Integer.parseInt(String.valueOf(raiz.getDato()))) {
                    result = raiz.getDato();
                }else
                    result = raiz.getDato();
            }
        }
        return result;
    }
}
