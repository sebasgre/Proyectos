package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radio = sc.nextInt();
        double calculate = (4/3.0) * 3.14159 * Math.pow(radio, 3);
        String result = String.format("VOLUME = %.3f", calculate);
        System.out.println(result);
    }
}
