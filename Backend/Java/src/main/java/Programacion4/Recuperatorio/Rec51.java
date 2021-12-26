package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) System.out.println(i + "^2 = " + (i * i));
        }
    }
}
