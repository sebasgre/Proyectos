package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double time = sc.nextDouble();
        double mediaSpeed = sc.nextDouble();
        String result = String.format("%.3f", (time * mediaSpeed) / 12);
        System.out.println(result);
    }
}
