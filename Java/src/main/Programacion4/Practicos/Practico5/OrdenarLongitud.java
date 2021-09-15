package Programacion4.Practicos.Practico5;

import java.util.Scanner;

public class OrdenarLongitud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String linea = "";
        StringBuilder sb = new StringBuilder();
        String[] valores = linea.split(" ");
        String[] aux = new String[n];
        if (n > 0) {
            for (int i = 0; i <= n; i++) {
                linea = sc.nextLine();
                valores = linea.split(" ");
                aux[i] = linea;
            }
            ordenar(valores);
            for (int i = 0; i < valores.length; i++) {
                if (aux[i].contains(valores[i])) {
                    sb.append(valores[i] + " ");
                }
            }
            System.out.println(sb);
        }

        
    }

    public static void ordenar(String vector[]) {
        String temp;
        for (int i = 1; i < vector.length; i++) {
            for (int j = 0; j < vector.length - 1; j++) {
                if (vector[j].length() > vector[j + 1].length()) {
                    temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }
}
