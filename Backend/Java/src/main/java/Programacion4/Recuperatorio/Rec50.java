package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dentroDeIntervalo = 0;
        int fueraDeIntervalo = 0;
        for (int i = 0; i < n; i++) {
            int numero = sc.nextInt();
            if (numero >= 10 && numero <= 20) {
                dentroDeIntervalo++;
            } else {
                fueraDeIntervalo++;
            }
        }
        System.out.println(dentroDeIntervalo + " in");
        System.out.println(fueraDeIntervalo + " out");
    }
}
