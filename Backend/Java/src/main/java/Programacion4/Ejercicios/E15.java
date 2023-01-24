package Programacion4.Ejercicios;

import java.util.Scanner;

public class E15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros para visualizar en la serie");
        int n = sc.nextInt();// --> 7
        int validar = n;
        int k = 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {// --> realiza las veces que se tiene que ejecutar por linea
            String acumulador = "";
            int pos = i;
            if (validar == 1) {
                pos -= k;
                k+= 2;
            }
            for (int j = 1; j <= pos; j++) { // --> llena los valores a la secuencia
                int espacios = 4;
                acumulador += String.valueOf(j);
                while (espacios > 0) {
                    acumulador += " ";
                    espacios--;
                }
            }
            sb.append(acumulador).append("\n");
            if (validar != 1) {
                if (pos > 1)
                    validar -= 2;
            }
        }
        System.out.println(sb);
    }
}
