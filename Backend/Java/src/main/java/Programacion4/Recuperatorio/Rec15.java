package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        float y = Float.parseFloat(sc.nextLine());
        double calculated = x/y;
        String result = String.format("%.3f",calculated);
        System.out.println(result + " km/l");
    }
}
