package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i < 6; i++) {
            double numero = sc.nextDouble();
            if(numero >= 0){
                total++;
            }
        }
        System.out.println(total + " valores positivos");
    }
}
