package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        int ano = 0;
        int mes = 0;
        int dia = 0;
        while (age > 0) {
            if (age / 365 > 0) {
                ano++;
                age -= 365;
            } else if (age / 30 > 0 && age / 30 < 365) {
                mes++;
                age -= 30;
            } else {
                dia++;
                age -= 1;
            }
        }
        System.out.println(ano + " ano(s)");
        System.out.println(mes + " mes(es)");
        System.out.println(dia + " dia(s)");
    }
}
