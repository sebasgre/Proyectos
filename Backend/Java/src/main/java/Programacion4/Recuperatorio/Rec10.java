package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        double salary, sales;
        salary = Double.parseDouble(sc.nextLine());
        sales = Double.parseDouble(sc.nextLine());
        double calculate = (sales * 0.15) + salary;
        String result = String.format("TOTAL = R$ %.2f", calculate);
        System.out.println(result);
    }
}
