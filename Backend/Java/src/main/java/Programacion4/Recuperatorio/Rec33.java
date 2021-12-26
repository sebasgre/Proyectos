package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int horas = a == b ? 24 : a > b ? ((24 - a) + b) : b - a;
        System.out.println("O JOGO DUROU " + horas + " HORA(S)");
    }
}
