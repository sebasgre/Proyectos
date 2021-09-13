package Java.demo.src.main.java.Programacion4.Practicos;

import java.util.Arrays;

public class Practico1 {
    public static void main(String[] args) {

        // int[] arreglo = { 9, 2, 0, 13, 25, 0, 15, 0,2, 5, 13, 2, 25 };

        // Generamos un arreglo de numeros aleatorios
        int[] arreglo = new int[10000000];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 1000);
        }

        // Ordenando el arreglo
        long inicio = System.currentTimeMillis();
        getCantidadNumerosDiferentes(arreglo);
        long fin = System.currentTimeMillis();
        System.out.println(fin - inicio);

        // Quita los repetidos
        inicio = System.currentTimeMillis();
        getCantidadNumerosDiferentes2(arreglo);
        ;
        fin = System.currentTimeMillis();
        System.out.println(fin - inicio);

        // Guarda los que se va encontrando para consultar
        inicio = System.currentTimeMillis();
        getCantidadNumerosDiferentes3(arreglo);
        fin = System.currentTimeMillis();
        System.out.println(fin - inicio);

    }

    /**
     * Obtiene la cantidad de numeros no repetidos ordenando primero el arreglo
     * 
     * @param temp
     * @return
     */
    public static int getCantidadNumerosDiferentes(int[] temp) {
        // Validamos los casos en que nos pueden pasar un arreglo nulo o vacio
        if (temp == null || temp.length == 0) {
            return 0;
        }

        // Podemos asegurarnos que el arreglo de entrada no sea modificado
        // clonando dicho arreglo y asignadolo a un arreglo temporal
        // Esto por que el método Arrays.sort(...) modifica el arreglo de entrada
        int[] arreglo = temp.clone();
        java.util.Arrays.sort(arreglo);

        int anterior = arreglo[0];
        int cantidadDiferentes = 1;

        for (int i = 1; i < arreglo.length; i++) {
            int actual = arreglo[i];

            if (anterior != actual) {
                cantidadDiferentes++;
                anterior = actual;
            }
        }

        return cantidadDiferentes;
    }

    /**
     * Obtiene la cantidad de numeros no repetidos quitando los repetidos
     * 
     * @param temp
     * @return
     */
    public static int getCantidadNumerosDiferentes2(int[] temp) {
        // Validamos los casos en que nos pueden pasar un arreglo nulo o vacio
        if (temp == null || temp.length == 0)
            return 0;

        Integer[] arreglo = Arrays.stream(temp).boxed().toArray(Integer[]::new);

        // Esto es lo equivalente a la linea anterior
        // Integer[] arreglo = new Integer[temp.length];

        // String[] arregloString = new String[arreglo.length];
        // for (int i = 0; i < temp.length; i++) {
        // arreglo[i] = temp[i];
        // }

        int cantidadDiferentes = 0;

        for (int i = 0; i < arreglo.length; i++) {
            Integer actual = arreglo[i];
            if (actual != null) {
                quitarIguales(actual, arreglo, i + 1);
                cantidadDiferentes++;
            }
        }

        return cantidadDiferentes;
    }

    private static void quitarIguales(Integer actual, Integer[] arreglo, int i) {
        for (; i < arreglo.length; i++) {
            if (actual.equals(arreglo[i])) {
                arreglo[i] = null;
            }
        }
    }

    /**
     * Obtiene la cantidad de numeros no repetidos guardando los numeros únicos
     * 
     * @param arreglo
     * @return
     */
    public static int getCantidadNumerosDiferentes3(int[] arreglo) {
        // Validamos los casos en que nos pueden pasar un arreglo nulo o vacio
        if (arreglo == null || arreglo.length == 0)
            return 0;

        int[] unicos = new int[arreglo.length];

        unicos[0] = arreglo[0];
        int cantidadDiferentes = 1;

        for (int i = 1; i < arreglo.length; i++) {
            int actual = arreglo[i];

            if (buscar(unicos, actual, cantidadDiferentes) == false) {
                unicos[cantidadDiferentes] = actual;
                cantidadDiferentes++;
            }
        }

        return cantidadDiferentes;
    }

    private static boolean buscar(int[] arreglo, int valor, int limite) {
        for (int i = 0; i < limite; i++) {
            if (arreglo[i] == valor)
                return true;
        }
        return false;
    }
}
