package Programacion4.Ejercicios;

import javax.swing.*;
import java.util.Scanner;

public class e5 {
    public static void main(String[] args) {

        //Indicamos el tamaño
        String texto = JOptionPane.showInputDialog("Introduce un tamaño");
        int[] num = new int[Integer.parseInt(texto)];

        //Invocamos las funciones
        rellenarNumPrimosAleatorioArray(num, 1, 100);
        mostrarArray(num);

        //Saco el primo mayor
        int primoMayor = mayor(num);
        System.out.println("El primo más grande es el " + primoMayor);
    }

    public static void rellenarNumPrimosAleatorioArray(int[] lista, int a, int b) {

        int i = 0;

        //Usamos mejor un while, ya que solo aumentara cuando genere un primo
        while (i < lista.length) {
            int num = ((int) Math.floor(Math.random() * (a - b) + b));
            if (esPrimo(num)) {
                lista[i] = num;
                i++;
            }
        }
    }

    private static boolean esPrimo(int num) {

        //Un numero negativo, el 0 y el 1, son directamente no primos.
        if (num <= 1) {
            return false;
        } else {

            //declaracion
            int prueba;
            int contador = 0;
            //Hacemos la raiz cuadrada y lo usamos para dividir el numero original
            prueba = (int) Math.sqrt(num);
            //Bucle que cuenta los numeros divisibles, podemos hacerlo con while
            for (; prueba > 1; prueba--) {
                if (num % prueba == 0) {
                    contador++;
                }
            }
            return contador < 1;
        }
    }

    public static void mostrarArray(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("En el indice " + i + " esta el valor " + lista[i]);
        }
    }

    public static int mayor(int[] lista) {
        int mayor = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > mayor) {
                mayor = lista[i];
            }
        }
        return mayor;
    }
}
