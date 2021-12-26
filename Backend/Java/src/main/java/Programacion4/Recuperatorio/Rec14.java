package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int a,b,c;
        a = Integer.parseInt(line.split(" ")[0]);
        b = Integer.parseInt(line.split(" ")[1]);
        c = Integer.parseInt(line.split(" ")[2]);
        int calculated = 0;
        if (a > b && a > c) {
            calculated = a;
        }else if (b > c) {
            calculated = b;
        } else
            calculated = c;
        System.out.println(calculated + " eh o maior");
    }
}
