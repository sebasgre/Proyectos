package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int total = 0;
        int desde = Math.min(x,y) + 1;
        int hasta = Math.max(x,y);
        for (int i = desde; i < hasta; i++) {
            if (Math.abs(i) % 2 == 1) {
                total += i;
            }
        }
        System.out.println(total);
    }
}
