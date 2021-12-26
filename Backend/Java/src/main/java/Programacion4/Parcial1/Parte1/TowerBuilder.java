package Programacion4.Parcial1.Parte1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TowerBuilder {

    public ArrayList<ArrayList<Integer>> build(InputStream in) {
        Scanner scanner = new Scanner(in);
        int dias = scanner.nextInt();
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 0 => o1 == o2
                //< 0 => o1 < o2
                //> 0 => o1 > o2
                return o2 - o1; // Descendente
            }
        };

        //numeros.sort(comparator); // 4 5 1 2 3
        int temp = dias;

        for (int i = 0; i < dias; i++) {
            int valores = scanner.nextInt();
            ArrayList<Integer> discosOrdenados = new ArrayList<>();
            numeros.add(valores); // desordenado
            numeros.sort(comparator); // ordenado
            while (!numeros.isEmpty() && numeros.get(0) == temp) {
                discosOrdenados.add(numeros.get(0)); // 5
                temp--;
                numeros.remove(0);
            }
            resultado.add(discosOrdenados);
        }
        return resultado;
    }

}
