package Java.demo.src.main.java.Programacion4.Practicos;

import java.util.Scanner;

public class Practico6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] prim = new boolean[10000];
        cribaEratostenes(prim);
        while (true) {
            int n = scanner.nextInt();
            if (n > 0 && n <= 10000) {
                System.out.println(esPrimo(prim, n) ? "Si" : "No");
            }
        }
    }

    private static boolean esPrimo(boolean[] prim, int n) {
        return !prim[n - 1];
    }

    private static void cribaEratostenes(boolean[] prim) {
        int raiz = (int) Math.sqrt(prim.length);
        for (int i = 2; i <= raiz; i++) {
            int aux = i;
            for (int j = 0; j < prim.length; j++) {
                aux += i;
                if (aux <= prim.length) {
                    prim[aux - 1] = true;
                }
            }
        }
    }
}
