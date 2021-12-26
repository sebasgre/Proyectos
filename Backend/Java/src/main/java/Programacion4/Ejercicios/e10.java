package Programacion4.Ejercicios;

import java.util.Scanner;

public class e10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros que desea ver");
        int cantidad = sc.nextInt();
        piramide(cantidad);
    }

    public static void piramide(int cantidad) {
        int valor = cantidad;
        int indice = 0;
        String asteriscos = "***";
        for (int i = 0; i <= cantidad; i++) {
            int c = valor;
            String espacios = "";
            while (c > 0) {
                espacios += " ";
                c--;
            }
            if (i % 2 == 0) {
                if (indice >= 2) {
                    System.out.print(espacios);
                    System.out.print(indice);
                    System.out.println(asteriscos + indice);
                    asteriscos += "****";
                } else {
                    System.out.print(espacios);
                    System.out.println(indice);
                }
                valor -= 2;
                indice += 2;
            }
        }
    }
}
