package Programacion4.Grafos.diccionario;

import java.util.ArrayList;
import java.util.List;

public class DiccionarioTablaHash<TKEY, TVALUE> extends Diccionario<TKEY, TVALUE> {

    private DiccionarioSecuencia<TKEY,TVALUE>[] elementos;
    private float factorCarga;
    private int limiteElementos;

    public DiccionarioTablaHash(Comparador<TKEY> comparador) {
        super(comparador);
        init();
    }

    public DiccionarioTablaHash() {
        super();
        init();
    }

    private void init(){
        int n = 11;
        factorCarga = 0.6f;
        limiteElementos = (int)(factorCarga * n);
        elementos = new DiccionarioSecuencia[n];
    }


    @Override
    public void insertar(TKEY key, TVALUE value) {
        //Si alance el limite de elementos
        if(cantidadElementos == limiteElementos){
            //Debo ampliar el arreglo de elementos y
            //volver a insertar los elementos almacenados
           // rehash();
        }

        //Obtengo la posicion del arreglo de elementos
        // que corresponde a la llave
        int index = getPosicion(key);
        //Verifico si no hay nada en esa posicion
        if(elementos[index] == null){
            //si no hay nada, le asigno un nuevo DiccionarioSecuencia
            elementos[index] = new DiccionarioSecuencia<>(super.comparador);
        }

        //Obtengo la cantidad de elementos que tiene el diccionarioSecuencia
        //en la posicion
        int anteriorCantidad = elementos[index].getCantidadElementos();

        //inserto la llave y el valor en el diccinarioSecuencia de la
        //posicion correspondiente
        elementos[index].insertar(key, value);

        //Verifico si el diccionarSecuencia en esa posicion insertó o
        //solamente actualizó
        if(elementos[index].getCantidadElementos() != anteriorCantidad) {
            //incremento la cantidad total
            cantidadElementos++;
        }
    }

    private boolean esPrimo(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    private void rehash() {
        //Calculuar un nuevo N
        int n = (elementos.length * 2) + 1;
        while (!esPrimo(n)){
            n++;
        }

        //Calcular un nuevo limite de elementos
        limiteElementos = (int)(factorCarga * n);
        //crear un nuevo arreglo
        DiccionarioSecuencia<TKEY,TVALUE>[] temp = new DiccionarioSecuencia[n];

        //volver a insertar los elementos del antiguo arreglo
        //al nuevo arreglo en base al nuevo N
        for (int i = 0; i < elementos.length; i++) {
            if(elementos[i] == null){
                continue;
            }

            Nodo<TKEY, TVALUE> actual = elementos[i].primero;
            while (actual != null) {
                int index = getPosicion(actual.getKey(), n);

                if (temp[index] == null)
                    temp[index] = new DiccionarioSecuencia<>(this.comparador);

                temp[index].insertar(actual.getKey(), actual.getValue());
                actual = actual.getSiguiente();
            }

        }

        elementos = temp;

    }

    @Override
    public TVALUE obtener(TKEY key) {
        int index = getPosicion(key);
        if(elementos[index] == null){
            return null;
        }

        return elementos[index].obtener(key);
    }

    @Override
    public TVALUE eliminar(TKEY key) {
        int index = getPosicion(key);
        if(elementos[index] == null){
            return null;
        }

        int anteriorCantidad = elementos[index].getCantidadElementos();

        TVALUE value = elementos[index].eliminar(key);

        if(anteriorCantidad != elementos[index].getCantidadElementos()){
            cantidadElementos--;
        }

        return value;
    }

    @Override
    public boolean contineLlave(TKEY key) {
        int index = getPosicion(key);
        if(elementos[index] == null){
            return false;
        }

        return elementos[index].contineLlave(key);
    }

    @Override
    public List<TKEY> getLlaves() {
        List<TKEY> list = new ArrayList<>();
        for (Diccionario<TKEY, TVALUE> dic : elementos) {
            if(dic == null){
                continue;
            }

            list.addAll(dic.getLlaves());
        }
        return list;
    }

    @Override
    public List<TVALUE> getValores() {
        List<TVALUE> list = new ArrayList<>();
        for (Diccionario<TKEY, TVALUE> dic : elementos) {
            if(dic == null){
                continue;
            }

            list.addAll(dic.getValores());
        }
        return list;
    }

    private int getPosicion(TKEY key, int n){
        return (comparador.getHashCode(key) & 0x7FFFFFFF) % n;
    }

    private int getPosicion(TKEY key) {
        return getPosicion(key, elementos.length);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String separator = "";
        for (Diccionario<TKEY, TVALUE> dic : elementos) {
            String value = dic == null ? "X" : dic.toString();

            str.append(separator).append(value);
            separator = "\n";
        }

        return str.toString();
    }
}
