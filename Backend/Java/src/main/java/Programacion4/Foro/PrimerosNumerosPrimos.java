package Programacion4.Foro;

import java.util.Scanner;

public class PrimerosNumerosPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String respuesta = "";
        int numeroPrimo = 2;
        for (int i = 1; i <= n;) {
            respuesta = determinarFactoresPrimos(numeroPrimo);
            int pos = respuesta.indexOf(" ");
            if (respuesta.substring(pos + 1).equalsIgnoreCase("es primo")) {
                System.out.println(respuesta);
                i++;
            }
            numeroPrimo++;
        }
    }

    public static String determinarFactoresPrimos(int n) {
        int contador = 0;
        String respuesta = "";
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                contador++;
        }
        if (contador == 2)
            respuesta = n + " es primo";
        else
            respuesta = n + " no es primo";
        return respuesta;
    }


}
