package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, hours;
        number = Integer.parseInt(sc.nextLine());
        hours = Integer.parseInt(sc.nextLine());
        float salary = Float.parseFloat(sc.nextLine());
        System.out.println("NUMBER = " + number);
        String result = String.format("SALARY = U$ %.2f",salary * hours);
        System.out.println(result);
    }
}
