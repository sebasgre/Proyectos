package Programacion4.Pruebas;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeraParte1 {
    public ArrayList<ArrayList<Integer>> build(InputStream in) {
        Scanner sc = new Scanner(in);
        String line = String.valueOf(sc.nextLine().split(" "));

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dias = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] numbers = line.split(" ");
        List<List<Integer>> resultado = new ArrayList<>();
        int proximo = dias;
        int[] esperando = new int[dias];
        for (int i = 0; i < dias; i++) {
            int value = Integer.parseInt(numbers[i]);
            List<Integer> dia = new ArrayList<>();
            if (value == proximo) {
                dia.add(Integer.parseInt(numbers[i]));
                proximo--;
                while (proximo > 0) {
                    if (esperando[proximo - 1] == proximo) {
                        dia.add(proximo);
                        proximo--;
                    } else {
                        break;
                    }
                }
            } else {
                esperando[value - 1] = value;
            }
            resultado.add(dia);
        }
        System.out.println(Arrays.toString(new ArrayList[]{(ArrayList) resultado}));
    }
}


    /*
     Scanner scan = new Scanner(System.in);
        int dias = scan.nextInt();

        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();

        int proximo = dias;

        int[] esperando = new int[dias];

        for (int i = 0; i < dias; i++) {
            ArrayList<Integer> dia = new ArrayList<>();
            int nuevo = scan.nextInt();
            if (nuevo == proximo) {
                dia.add(nuevo);
                proximo--;
                while (proximo > 0) {
                    if (esperando[proximo - 1] == proximo) {
                        dia.add(proximo);
                        proximo--;
                    } else {
                        break;
                    }
                }
            } else {
                esperando[nuevo - 1] = nuevo;
            }
            resultado.add(dia);
            System.out.println(Arrays.toString(new ArrayList[]{resultado}));
     */

