package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salario = sc.nextDouble();
        double nuevoSalario = 0;
        double reajuste = 0;
        int porcentaje = 0;
        if(salario >= 0 && salario <= 400){
            porcentaje = 15;
        } else if (salario >= 400.01 && salario <= 800){
            porcentaje = 12;
        } else if (salario >= 800.01 && salario <= 1200){
            porcentaje = 10;
        } else if (salario >= 1200.01 && salario <= 2000){
            porcentaje = 7;
        } else if (salario > 2000){
            porcentaje = 4;
        }
        reajuste = salario * porcentaje / 100;
        nuevoSalario = salario + reajuste;
        System.out.printf("Novo salario: %.2f%n", nuevoSalario);
        System.out.printf("Reajuste ganho: %.2f%n", reajuste);
        System.out.println("Em percentual: " + porcentaje + " %");
    }
}
