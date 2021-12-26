package Programacion4.Pruebas;

import java.util.Scanner;

public class ContarVocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su palabra para contar vocales");
        String palabra = sc.nextLine().toLowerCase();
        int contarVocales = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contarVocales++;
            }
        }
        System.out.println("La palabra ingresada tiene " + contarVocales + " vocales");
    }
}
