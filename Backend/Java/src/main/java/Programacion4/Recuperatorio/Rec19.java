package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int[] size = {100, 50, 20, 10, 5, 2, 1};
        System.out.println(value);
        for (int i = 0; i < size.length; i++) {
            System.out.println(value/size[i] + " nota(s) de R$ " + size[i] + ",00");
            value = value%size[i];
        }
    }
}
