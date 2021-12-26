package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec48 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int x = leitor.nextInt();
        int cont = 0;
        while (cont < 6) {
            if (x % 2 == 1) {
                System.out.println(x);
                cont++;
            }
            x++;
        }
    }
}
