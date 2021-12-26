package Programacion4.Ejercicios;

import java.util.Scanner;

public class e8 {
    public static int sumatoria = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estudiantes");
        int nota = sc.nextInt();
        int[] cantidad = new int[nota];
        String[] estudiantes = new String[nota];
        rellenarInfo(estudiantes, cantidad);
        float promedio = (float) sumatoria / nota;
        int reprobados = verificarReprobados(cantidad);
        int aprobados = verificarAprobados(cantidad);
        int especiales = verificarEspeciales(cantidad);
        float porcentaje = (float) (especiales * 100) / nota;
        System.out.println("La cantidad de estudiantes reprobados es de: " + reprobados);
        System.out.println("La cantidad de estudiantes aprobados es de: " + aprobados);
        System.out.println("El promedio del curso es de: " + promedio);
        System.out.println("El porcentaje de estudiantes con nota menores o iguales a 15 es de: " + porcentaje + "%");
    }

    public static void rellenarInfo(String[] lista, int[] notas) {
        String nombre = "";
        int nota;
        for (int i = 0; i < lista.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del estudiante");
            nombre = scanner.nextLine();
            System.out.println("Ingrese la nota de " + nombre);
            nota = scanner.nextInt();
            lista[i] = nombre;
            notas[i] = nota;
            sumatoria += notas[i];
        }
    }



    public static int verificarAprobados(int[] notas) {
        int aprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 51) {
                aprobados++;
            }
        }
        return aprobados;
    }

    public static int verificarReprobados(int[] notas) {
        int reprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] <= 50) {
                reprobados++;
            }
        }
        return reprobados;
    }

    public static int verificarEspeciales(int[] notas) {
        int especiales = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] <= 15) {
                especiales++;
            }
        }
        return especiales;
    }
}
