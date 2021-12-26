package Programacion4.Pruebas;

import java.util.HashMap;
import java.util.Scanner;

public class Moneda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int moneda = sc.nextInt();
        int[] cortes = {20,10,5,2,1};
        HashMap<Integer, Integer> valores = new HashMap<>();
        for (int i = cortes.length - 1; i >= 0; i--) {
            int calculo = moneda / cortes[i];
            moneda -= (calculo * cortes[i]);
            valores.put(cortes[i], calculo);
        }
        System.out.println(valores);
    }
}
