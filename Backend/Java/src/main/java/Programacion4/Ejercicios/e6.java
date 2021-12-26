package Programacion4.Ejercicios;

public class e6 {
    public static void main(String[] args) {
        int[] vector = new int[100];
        rellenarNumPrimosAleatorioArray(vector);
        mostrarArray(vector);
        int sumatoria = laSumatoria(vector);
        System.out.println("La suma es de: " + sumatoria);
        float media = laMedia(vector);
        System.out.println("La media es de: " + media);
    }

    public static void rellenarNumPrimosAleatorioArray(int[] lista) {
        int contador = 1;
        for (int i = 0; i < lista.length; i++) {
            lista[i] = contador;
            contador++;
        }
    }

    public static int laSumatoria(int[] lista) {
        int suma = 0;
        for (int i = 0; i < lista.length; i++) {
            suma += lista[i];
        }
        return suma;
    }

    public static float laMedia(int[] lista) {
        float media = (float) laSumatoria(lista) / lista.length;
        return media;
    }

    public static void mostrarArray(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("En el indice " + i + " esta el valor " + lista[i]);
        }
    }
}
