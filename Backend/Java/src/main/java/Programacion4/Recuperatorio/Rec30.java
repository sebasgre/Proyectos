package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        if ((a + b) > c && (b + c) > a && (c + a) > b) {
            double perimetro = a + b + c;
            System.out.printf("Perimetro = %.1f%n", perimetro);
        } else {
            double areaTrapecio = ((a + b) / 2) * c;
            System.out.printf("Area = %.1f%n", areaTrapecio);
        }
    }
}
