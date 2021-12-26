package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        float x1, y1, x2, y2;
        x1 = Float.parseFloat(line1.split(" ")[0]);
        y1 = Float.parseFloat(line1.split(" ")[1]);
        x2 = Float.parseFloat(line2.split(" ")[0]);
        y2 = Float.parseFloat(line2.split(" ")[1]);
        double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
        String result = String.format("%.4f", distance);
        System.out.println(result);
    }
}
