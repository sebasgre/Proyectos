package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Float A,B,C;
        String line = sc.nextLine();
        A = Float.parseFloat(line.split(" ")[0]);
        B = Float.parseFloat(line.split(" ")[1]);
        C = Float.parseFloat(line.split(" ")[2]);
        double areaTriangle, areaCircle, areaTrape, areaSquare, areaRectangle;
        areaTriangle = (A * C) / 2;
        String result = String.format("TRIANGULO: %.3f", areaTriangle);
        System.out.println(result);
        areaCircle = Math.pow(C,2) * 3.14159;
        result = String.format("CIRCULO: %.3f", areaCircle);
        System.out.println(result);
        areaTrape = ((A + B) * C) / 2;
        result = String.format("TRAPEZIO: %.3f", areaTrape);
        System.out.println(result);
        areaSquare = Math.pow(B,2);
        result = String.format("QUADRADO: %.3f", areaSquare);
        System.out.println(result);
        areaRectangle = A * B;
        result = String.format("RETANGULO: %.3f", areaRectangle);
        System.out.println(result);
    }
}
