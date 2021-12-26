package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double positivos = 0;
        double promedio = 0;
        for (int i = 0; i < 6; i++) {
            double numero = sc.nextDouble();
            if(numero >= 0){
                positivos++;
                promedio += numero;
            }
        }
        System.out.println((int)positivos + " valores positivos");
        System.out.printf("%.1f%n", promedio / positivos);
    }
}
