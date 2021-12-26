package Programacion4.Recuperatorio;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Rec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double area = 3.14159 * Math.pow(radius,2);
        DecimalFormat format = new DecimalFormat("#.0000");
        System.out.println("A=" + format.format(area));
    }
}
