package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a % b == 0 || b % a == 0 ? "Sao Multiplos" : "Nao sao Multiplos");
    }
}
