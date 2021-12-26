package Programacion4.Recuperatorio;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Rec32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea = sc.nextLine();
        String[] valores = linea.split(" ");
        Double[] vector = new Double[valores.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Double.parseDouble(valores[i]);
        }
        Arrays.sort(vector, Collections.reverseOrder());
        double a = vector[0];
        double b = vector[1];
        double c = vector[2];
        if (a >= b + c) {
            System.out.println("NAO FORMA TRIANGULO");
        } else {
            if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) {
                System.out.println("TRIANGULO RETANGULO");
            }

            if (Math.pow(a, 2) > Math.pow(b, 2) + Math.pow(c, 2)) {
                System.out.println("TRIANGULO OBTUSANGULO");
            }

            if (Math.pow(a, 2) < Math.pow(b, 2) + Math.pow(c, 2)) {
                System.out.println("TRIANGULO ACUTANGULO");
            }

            if (a == b && b == c && a == c) {
                System.out.println("TRIANGULO EQUILATERO");
            }

            if (a == b && c != a && c != b) {
                System.out.println("TRIANGULO ISOSCELES");
            } else if (b == c && a != b && a != c) {
                System.out.println("TRIANGULO ISOSCELES");
            } else if (c == a && b != a && b != c) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
}
