package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec6 {
    public static void main(String[] args) {
        float a, b, med;
        Scanner sc = new Scanner(System.in);
        a = sc.nextFloat();
        b = sc.nextFloat();
        med = (float) (((a * 3.5) + (b * 7.5)) / (3.5 + 7.5));
        String media = String.format("MEDIA = %,.5f", med);
        System.out.print(media +"\n");
    }
}
