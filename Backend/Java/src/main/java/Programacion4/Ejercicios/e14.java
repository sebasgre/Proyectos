package Programacion4.Ejercicios;

import java.util.Scanner;

public class e14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int num = sc.nextInt();
        arbol(num);
    }

    public static void arbol(int cant) {
        String asterisco = "*";
        for (int i = 0; i < cant; i++) {
            String espacios = "";
            int a = cant;
            while (a > i) {
                espacios += " ";
                a--;
            }
            System.out.print(espacios);
            System.out.println(asterisco);
            asterisco += "**";
            if (i == cant - 1) {
                int b = 0;
                while (b < i) {
                    espacios += " ";
                    b++;
                }
                System.out.println(espacios + "|");
            }
        }
    }
}
