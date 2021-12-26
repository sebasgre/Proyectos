package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        while (n > 0) {
            if (n / 3600 >= 1) {
                hours++;
                n -= 3600;
            } else if (n / 60 > 0 && n / 60 < 60) {
                minutes++;
                n -= 60;
            } else {
                seconds++;
                n -= 1;
            }
        }
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}
