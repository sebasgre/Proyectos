package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hasta = sc.nextInt();
        for (int i = 1; i <= hasta; i+=2) {
            System.out.println(i);
        }
    }
}
