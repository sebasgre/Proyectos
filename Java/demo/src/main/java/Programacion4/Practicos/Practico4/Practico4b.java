package Java.demo.src.main.java.Programacion4.Practicos.Practico4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practico4b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // --> 2
        Queue<String> cola = new LinkedList<String>();
        String entrada = "";
        for (int i = 0; i < n; i++) {
            entrada = sc.next();
            cola.add(entrada);
            for (String string : cola) {
                int contadorMenores = 0;
                int resultado = 0;
                for (int j = 0; j < string.length(); j++) {
                    if (string.charAt(j) == '<') {
                        contadorMenores++;
                    } else if (string.charAt(j) == '>' && contadorMenores > 0) {
                        contadorMenores--;
                        resultado++;
                    }
                }
                System.out.println(resultado);
                cola.poll();
            }
        }
    }
}
