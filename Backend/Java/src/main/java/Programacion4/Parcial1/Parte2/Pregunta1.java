package Programacion4.Parcial1.Parte2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pregunta1 {
    public List<Integer> resolver(InputStream in) {
        List<Integer> salidas = new ArrayList<>();
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] vector = new int[n];
        for (int i = 0; i < vector.length; i++) {
            int numero = scanner.nextInt();
            vector[i] = numero;
        }

        for (int i = 0; i < q; i++) {
            int tipo = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (tipo == 1) {
                if (a >= 0 && a <= vector.length - 1) {
                    vector[a] = b;
                }
            } else {
                if (a >= 0 && b <= vector.length - 1) {
                    int suma = 0;
                    for (int j = a; j <= b; j++) {
                        suma += vector[j];
                    }
                    salidas.add(suma);
                } else {
                    salidas.add(-1);
                }
            }
        }
        return salidas;
    }

    public void out(List<Integer> salida, int valor) {
        salida.add(valor);
        System.out.println(valor);
    }

    public static void main(String[] args) {
//        Pregunta1 pregunta1 = new Pregunta1();
//        pregunta1.resolver(System.in);
        List<Integer> salidas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] vector = new int[n];
        for (int i = 0; i < vector.length; i++) {
            int numero = scanner.nextInt();
            vector[i] = numero;
        }

        for (int i = 0; i < q; i++) {
            int tipo = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (tipo == 1) {
                if (a >= 0 && a <= vector.length - 1) {
                    vector[a] = b;
                }
            } else {
                if (a >= 0 && b <= vector.length - 1) {
                    int suma = 0;
                    for (int j = a; j <= b; j++) {
                        suma += vector[j];
                    }
                    salidas.add(suma);
                } else {
                    salidas.add(-1);
                }
            }
        }
        System.out.println(Arrays.toString(new List[]{salidas}));
    }
}
