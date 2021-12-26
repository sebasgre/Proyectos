package Programacion4.Practico5;

import java.util.Scanner;

public class Bloques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        int p = 0;
        int f = 0;
        int v = 0;
        do {
            m = sc.nextInt();
            p = sc.nextInt();
            f = sc.nextInt();
            int contador = 0;

            if (p > 0 && f > 0) {
                int[][] matriz = new int[m][p];
                int[] vector = new int[f];
                for (int x = 0; x < matriz.length; x++) {
                    for (int y = 0; y < matriz[x].length; y++) {
                        matriz[x][y] = sc.nextInt();
                    }
                }


                for (int i = 0; i < f; i++) {
                    vector[i] = sc.nextInt();
                }


                v = matriz.length - 1;
                for (int j = matriz[v].length - 1; j >= 0; j--) {
                    for (int i = matriz.length - 1; i >= 0; i--) {
                        if (matriz[i][j] == 0) {
                            if (contador < matriz.length) {
                                matriz[i][j] = vector[contador];
                                contador++;
                            }
                        }
                    }
                    v--;
                }

                for (int[] ints : matriz) {
                    String espacio = "";
                    for (int anInt : ints) {
                        System.out.print(espacio + anInt);
                        espacio = " ";
                    }
                    System.out.println("");
                }
            }


        } while (p != 0 && f != 0);

    }
}
