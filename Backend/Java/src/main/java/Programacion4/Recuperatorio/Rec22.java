package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec22 {
    public static void main(String[] args) {
        Scanner sam = new Scanner(System.in);
        float a = sam.nextFloat();

        int hun = (int) (a / 100);
        int fif = (int) (a % 100 / 50);
        int twe = (int) (a % 100) % 50 / 20;
        int ten = (int) (a % 100) % 50 % 20 / 10;
        int fiv = (int) (a % 100) % 50 % 20 % 10 / 5;
        int two = (int) (a % 100) % 50 % 20 % 10 % 5 / 2;
        int one = (int) (a % 100) % 50 % 20 % 10 % 5 % 2 / 1;
        int remain = (int) (a * 100);
        remain = remain % 100;
        int half = remain / 50;
        int quart = remain % 50 / 25;
        int pten = remain % 50 % 25 / 10;
        int pfiv = remain % 50 % 25 % 10 / 5;
        int pone = remain % 50 % 25 % 10 % 5 / 1;

        System.out.println("NOTAS:");
        System.out.printf("%d nota(s) de R$ 100.00\n", hun);
        System.out.printf("%d nota(s) de R$ 50.00\n", fif);
        System.out.printf("%d nota(s) de R$ 20.00\n", twe);
        System.out.printf("%d nota(s) de R$ 10.00\n", ten);
        System.out.printf("%d nota(s) de R$ 5.00\n", fiv);
        System.out.printf("%d nota(s) de R$ 2.00\n", two);
        System.out.println(remain);
        System.out.println("MOEDAS:");
        System.out.printf("%d moeda(s) de R$ 1.00\n", one);
        System.out.printf("%d moeda(s) de R$ 0.50\n", half);
        System.out.printf("%d moeda(s) de R$ 0.25\n", quart);
        System.out.printf("%d moeda(s) de R$ 0.10\n", pten);
        System.out.printf("%d moeda(s) de R$ 0.05\n", pfiv);
        System.out.printf("%d moeda(s) de R$ 0.01\n", pone);
    }
}
