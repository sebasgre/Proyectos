package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        int codeProduct1, codeProduct2, numProduct1, numProduct2;
        float prize1, prize2;
        codeProduct1 = Integer.parseInt(line1.split(" ")[0]);
        numProduct1 = Integer.parseInt(line1.split(" ")[1]);
        prize1 = Float.parseFloat(line1.split(" ")[2]);
        codeProduct2 = Integer.parseInt(line2.split(" ")[0]);
        numProduct2 = Integer.parseInt(line2.split(" ")[1]);
        prize2 = Float.parseFloat(line2.split(" ")[2]);
        double calculate = (prize1 * numProduct1) + (prize2 * numProduct2);
        String result = String.format("VALOR A PAGAR: R$ %.2f", calculate);
        System.out.println(result);
    }
}
