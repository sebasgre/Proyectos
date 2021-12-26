package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pares = 0;
        for (int i = 0; i < 5; i++) {
            int numero = sc.nextInt();
            if(numero % 2 == 0){
                pares++;
            }
        }
        System.out.println(pares + " valores pares");
    }
}
