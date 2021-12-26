package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int positivos = 0, negativos = 0, pares = 0, impares = 0;
        for (int i = 0; i < 5; i++) {
            int numero = sc.nextInt();
            if(numero > 0){
                positivos++;
            } else if(numero < 0){
                negativos++;
            }
            numero = Math.abs(numero);
            if(numero % 2 == 0){
                pares++;
            } else {
                impares++;
            }
        }
        System.out.println(pares + " valor(es) par(es)");
        System.out.println(impares + " valor(es) impar(es)");
        System.out.println(positivos + " valor(es) positivo(s)");
        System.out.println(negativos + " valor(es) negativo(s)");
    }
}
