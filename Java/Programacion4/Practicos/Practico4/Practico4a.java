package Java.Programacion4.Practicos.Practico4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Practico4a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            procesar(n);
            n = sc.nextInt();
        }
    }

    private static void procesar(int n) {
        Queue<Integer> deck = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            deck.add(i);
        }
        StringBuilder salidaDescartados = new StringBuilder("Discarded cards: ");
        StringBuilder separador = new StringBuilder();
        StringBuilder comma = new StringBuilder(", ");
        List<Integer> descartados = new ArrayList<>();
        boolean descartar = true;
        while (deck.size() > 1) {
            int carta = deck.poll();
            if (descartar) {
                salidaDescartados.append(separador).append(carta);
                separador = comma;
            }
                
            else
                deck.add(carta);
            descartar = !descartar;
        }
        String salidaRestante = "Remaining card: " + deck.peek().toString();
        for (Integer k : descartados) {
            salidaDescartados.append(separador).append(k);
            separador = comma;
        }
        System.out.println(salidaDescartados);
        System.out.println(salidaRestante);
    }

}
