package Java.demo.src.main.java.Programacion4.Practicos.Practico5;

import java.util.Scanner;

public class Bloques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        int p = 0;
        int f = 0;
        do {
            m = sc.nextInt();
            p = sc.nextInt();
            f = sc.nextInt();
            int matriz[][] = new int[m][p];
            int vector[] = new int[f];
            for (int x = 0; x < matriz.length; x++) {
                for (int y = 0; y < matriz[x].length; y++) {
                    matriz[x][y] = sc.nextInt();
                }
            }

            for (int i = 0; i < f; i++) {
                vector[i] = sc.nextInt();
            }
            
            int valor = 0;
            for (int x = 0; x < matriz.length; x++) {
                for (int y = matriz[x].length - 1; y > 0; y--) {
                    int fila = 0;
                    if (matriz[x][y] == 0) {
                        System.out.println("fila " + fila + " columna " + y);

                        while (matriz[fila][y] == 0) {
                            fila++;
                        }
                        matriz[fila - 1][y] = vector[valor];
                        valor++;
                        
                    }
                }
            }

            if (m != 0 && p != 0 && f != 0) {
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print(matriz[i][j] + " ");
                    }
                    System.out.println("");
                }
            }

        } while (m != 0 && p != 0 && f != 0);

    }

}
