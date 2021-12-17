package Programacion4.Practicas;

public class Buscador {
    public static boolean seEncuentra(int[] arreglo, int valueToSearch) {

        int[] vector = arreglo.clone();
        Arrays.sort(vector);
        int inicio = 0;
        int fin = vector.length - 1;

        while (inicio <= fin) {

            int mitad = (inicio + fin) / 2;
            if (vector[mitad] == valueToSearch) {
                // Si encontramos
                return true;
            } else if (valueToSearch > vector[mitad]) {
                inicio = mitad + 1;
            } else {
                fin = mitad - 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] arreglo = { 52, 18, 23, 1, 8, 20, 15 };

        System.out.println(seEncuentra(arreglo, 15));
        System.out.println(seEncuentra(arreglo, 23));
        System.out.println(seEncuentra(arreglo, 11));
        System.out.println(seEncuentra(arreglo, 3));
        System.out.println(seEncuentra(arreglo, 18));
    }
}
