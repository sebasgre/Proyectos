package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double value = sc.nextDouble();
        if (value < 0 || value > 100)
            System.out.println("Fora de intervalo");
        else if (value >= 0 && value <= 25)
            System.out.println("Intervalo [0,25]");
        else if (value >= 25 && value <= 50)
            System.out.println("Intervalo (25,50]");
        else if (value >= 75 && value <= 100)
            System.out.println("Intervalo (75,100]");
    }
}
