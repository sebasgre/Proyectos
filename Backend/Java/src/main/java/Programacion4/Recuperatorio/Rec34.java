package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int horai = sc.nextInt();
        int mini = sc.nextInt();
        int horaf = sc.nextInt();
        int minf = sc.nextInt();
        int horas = 0, minutos = 0;

        //int horas = a == b ? 24 : a > b ? ((24 - a) + b) : b - a;
        if (mini < minf) {
            minutos  = minf - mini;
        } else if (mini > minf) {
            minutos = 60 - mini + minf;
            horaf--;
        }
        if (horai <= horaf) {
            horas = horaf - horai;
        } else {
            horas = horaf - horai + 24;
        }
        if (horas == 0 && minutos == 0) {
            horas = 24;
        }
        System.out.println("O JOGO DUROU " + horas + " HORA(S) E " + minutos + " MINUTO(S)");
    }
}
