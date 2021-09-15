package Programacion4.Practicos;

import java.util.Scanner;

public class Practico3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = 0;
        int r = 0;
        do {
            String linea = sc.nextLine();
            String[] valores = linea.split(" ");
            l = Integer.parseInt(valores[0]);
            r = Integer.parseInt(valores[1]);
            if (l + r != 0)
                System.out.println(l + r);
        } while (l + r != 0);
    }
}
