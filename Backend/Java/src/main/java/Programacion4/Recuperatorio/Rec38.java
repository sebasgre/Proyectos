package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valor, impuesto = 0;
        valor = sc.nextDouble();
        if (valor >= 0.0 && valor <= 2000.00) {
            System.out.println("Isento");
        } else if (valor >= 2000.01 && valor <= 3000.00) {
            impuesto += (valor - 2000.00) * 0.08;
            System.out.printf("R$ %.2f%n", impuesto);
        } else if (valor >= 3000.01 && valor <= 4500.00) {
            impuesto += 1000.00 * 0.08;
            impuesto += (valor - 3000) * 0.18;
            System.out.printf("R$ %.2f%n", impuesto);
        } else if (valor > 4500.00) {
            impuesto += 1000.00 * 0.08;
            impuesto += 1500.00 * 0.18;
            impuesto += (valor - 4500.00) * 0.28;
            System.out.printf("R$ %.2f%n", impuesto);
        }
    }
}
