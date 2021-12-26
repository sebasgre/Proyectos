package Programacion4.Ejercicios;

import java.util.Scanner;

public class e9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros que desea ver");
        int cantidad = sc.nextInt();
        parteDeArriba(cantidad);
        parteDeAbajo(cantidad);
    }

    public static void parteDeArriba(int cantidad) {
        String result = "";
        int a = 1;
        for (int i = 0; i < cantidad; i++) {
            int valor = cantidad;
            String espacios = "";
            while (valor > i) {
                espacios += " ";
                valor--;
            }
            result += a;
            System.out.print(espacios);
            System.out.println(result);
            a++;
        }
    }

    public static void parteDeAbajo(int cantidad) {
        String espacios = "";
        int a = cantidad;
        for (int i = 0; i < cantidad; i++) {
            int valor = a;
            String result = "";
            if (cantidad > i) {
                espacios += " ";
            }
            while (valor > 0) {
                int b = valor;
                result += b;
                valor--;
            }
            a--;
            System.out.print(espacios);
            System.out.println(result);
        }
    }
}
