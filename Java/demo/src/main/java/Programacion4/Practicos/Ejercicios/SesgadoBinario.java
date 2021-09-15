package Programacion4.Practicos.Ejercicios;

import java.math.BigInteger;
import java.util.Scanner;

public class SesgadoBinario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger formula = new BigInteger("0");
        do {
            formula = sc.nextBigInteger();
            long calculo = 0;
            long result = 0;
            String expresion = String.valueOf(formula);
            int cantidad = expresion.length();
            for (int i = 0; i < expresion.length(); i++) {
                long numero = Long.parseLong(String.valueOf(expresion.charAt(i)));
                long valor = (long) Math.pow(2, cantidad) - 1;
                calculo = numero * valor;
                result += calculo;
                cantidad--;
            }
            if (formula.compareTo(BigInteger.valueOf(0)) != 0)
                System.out.println(result);
        } while (formula.compareTo(BigInteger.valueOf(0)) != 0);
    }
}
