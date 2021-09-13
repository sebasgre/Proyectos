package Java.demo.src.main.java.Programacion4.Practicas;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int numero = sc.nextInt();
        //System.out.println(factorial(numero));
        //otroCaso(numero);
        String valor = sc.nextLine();
        long a = Long.parseLong(valor);
        System.out.println(a + 80);
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    private static void otroCaso(int numero) {
        int factorial = 1;
        while (numero != 0) {
            factorial = factorial * numero;
            numero--;
        }
        System.out.println(factorial);
    }

    private static String primo(int numero) {
        if ((numero % numero == 1) && (numero % 1 == 0)) {
            return "Es numero primo";
        } else
            return "No es numero primo";

    }
}
