package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int desde = sc.nextInt();
        int i = desde;
        int veces = 6;
        while (veces > 0) {
            if(i % 2 == 1){
                System.out.println(i);
                veces--;
            }
            i++;
        }
    }
}
