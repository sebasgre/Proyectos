package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        if (b > c && d > a && c + d > a + b && c > 0 && d > 0 && a % 2 == 0)
            System.out.println("Valores aceitos");
        else
            System.out.println("Valores nao aceitos");
    }
}
