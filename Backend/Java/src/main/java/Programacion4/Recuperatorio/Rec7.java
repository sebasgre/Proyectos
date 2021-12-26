package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec7 {
    public static void main(String[] args) {
        float a, b, c, med;
        Scanner sc = new Scanner(System.in);
        a = sc.nextFloat();
        b = sc.nextFloat();
        c = sc.nextFloat();
        med = (float) (((a * 2) + (b * 3) + (c * 5)) / (2 + 3 + 5));
        String media = String.format("MEDIA = %,.1f", med);
        System.out.print(media +"\n");
    }
}
