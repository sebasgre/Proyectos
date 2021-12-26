package Programacion4.Ejercicios;

import java.util.Scanner;

public class e7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aprobados = 0;
        int reprobados = 0;
        int estudiantes = 0;
        int notas = 0;
        float promedio = 0;
        float porcentaje = 0;
        int suma = 0;
        int notasEspeciales = 0;
        System.out.println("Ingrese la cantidad de de estudiantes");
        estudiantes = sc.nextInt();
        int i = 0;
        while (i < estudiantes) {
            i++;
            System.out.println("Ingrese la nota del estudiante: " + i);
            notas = sc.nextInt();
            suma += notas;
            if (notas >= 51) {
                aprobados++;
            }else {
                reprobados++;
            }
            if (notas <= 15) {
                notasEspeciales++;
            }
        }
        System.out.println("La cantidad de estudiantes reprobados es de: " + reprobados);
        System.out.println("La cantidad de estudiantes aprobados es de: " + aprobados);
        promedio = (float) suma / notas;
        System.out.println("El promedio del curso es de: " + promedio);
        porcentaje = (float) (notasEspeciales * 100) / notas;
        System.out.println("El porcentaje de estudiantes con notas menores o iguales a 15 es de: " + porcentaje + "%");
    }
}
