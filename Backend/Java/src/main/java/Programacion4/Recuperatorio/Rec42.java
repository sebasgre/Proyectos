package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea1 = sc.nextLine();
        String linea2 = sc.nextLine();
        String linea3 = sc.nextLine();
        String linea4 = sc.nextLine();

        int diaInicio = Integer.parseInt(linea1.substring(4));
        String[] inicioHoraMinSeg = linea2.split(":");
        int iHora = Integer.parseInt(inicioHoraMinSeg[0].trim());
        int iMin = Integer.parseInt(inicioHoraMinSeg[1].trim());
        int iSegundo = Integer.parseInt(inicioHoraMinSeg[2].trim());

        int diaFinal = Integer.parseInt(linea3.substring(4));
        String[] finalHoraMinSeg = linea4.split(":");
        int fHora = Integer.parseInt(finalHoraMinSeg[0].trim());
        int fMin = Integer.parseInt(finalHoraMinSeg[1].trim());
        int fSegundo = Integer.parseInt(finalHoraMinSeg[2].trim());
        int totalDias = 0;
        int totalHoras = 0;
        int totalMinutos = 0;
        int totalSegundos = 0;
        //totalSegundos:
        if (fSegundo >= iSegundo) {
            totalSegundos = fSegundo - iSegundo;
        } else {
            totalSegundos = fSegundo - iSegundo + 60;
            fMin = fMin - 1;
        }
        //totalMinutos:
        if (fMin >= iMin) {
            totalMinutos = fMin - iMin;
        } else {
            totalMinutos = fMin - iMin + 60;
            fHora = fHora - 1;
        }
        //totalHoras:
        if (fHora >= iHora) {
            totalHoras = fHora - iHora;
        } else {
            totalHoras = fHora - iHora + 24;
            diaFinal = diaFinal - 1;
        }
        //totalDias:
        if (diaFinal >= diaInicio) {
            totalDias = diaFinal - diaInicio;
        }
        System.out.println(totalDias + " dia(s)");
        System.out.println(totalHoras + " hora(s)");
        System.out.println(totalMinutos + " minuto(s)");
        System.out.println(totalSegundos + " segundo(s)");
    }
}
