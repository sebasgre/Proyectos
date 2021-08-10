import java.util.Arrays;

public class Practico1 {
    public static void main(String[] args) {
        int[] arreglo = { 2, 13, 25, 15, 2, 5, 13, 2, 25 };
        int resultado = getCantidadNumerosDiferentes(arreglo);

        System.out.println(resultado);
        // El resultado deberia ser 5
    }

    public static int getCantidadNumerosDiferentes(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0)
            return 0;
        int contador = 1;
        int[] temp = arreglo.clone();
        Arrays.sort(temp);
        int anterior = temp[0];
        
        for (int i = 1; i < temp.length; i++) {
            int actual = temp[i];
            if(anterior != actual){
                contador++;
                anterior = actual;
            }
        }
        return contador;
    }
}
