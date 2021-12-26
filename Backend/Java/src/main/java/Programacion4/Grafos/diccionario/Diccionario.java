package Programacion4.Grafos.diccionario;

import java.util.List;

public abstract class Diccionario<TKEY, TVALUE> {

    protected Comparador<TKEY> comparador;
    protected int cantidadElementos;

    //Para cuando la llave es de un tipo de dato creado por el usuario
    public Diccionario(Comparador<TKEY> comparador) {
        if(comparador == null)
            throw new IllegalArgumentException("El comparador no puede ser nulo");
        this.comparador = comparador;
    }

    //Para cuando la llave es de un tipo de dato de JAVA
    public Diccionario(){
        this(new ComparadorGenerico<>());
    }

    /**
     * Inserta nuevos valores al diccinario
     * @param key llave a insertar
     * @param value valor vinculado a la llave a insertar
     */
    public abstract void insertar(TKEY key, TVALUE value);

    public abstract TVALUE obtener(TKEY key);

    public abstract TVALUE eliminar(TKEY key);

    public abstract boolean contineLlave(TKEY key);

    public abstract List<TKEY> getLlaves();

    public abstract List<TVALUE> getValores();

    public boolean estaVacio(){
        return cantidadElementos == 0;
    }

    public int getCantidadElementos(){
        return cantidadElementos;
    }
}
