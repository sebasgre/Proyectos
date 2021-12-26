package Programacion4.Ejercicios;

import java.util.Scanner;

public class e13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estudiantes");
        int cantidad = sc.nextInt();
        String[] nombres = new String[cantidad];
        int[] primerParcial = new int[cantidad];
        int[] segundoParcial = new int[cantidad];
        int[] examenFinal = new int[cantidad];
        int opcion = 0;
        correrPrograma(nombres, primerParcial, segundoParcial, examenFinal, opcion);
    }

    public static void mostrarMenu() {
        String[] menu = new String[5];
        menu[0] = "1.- Ver notas de un estudiante";
        menu[1] = "2.- Agregar estudiantes y notas";
        menu[2] = "3.- Ver promedio del estudiante";
        menu[3] = "4.- Ver promedio de la materia";
        menu[4] = "5.- Salir del programa";
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    public static void verNotas(String[] nombres, int[] notas1, int[] notas2, int[] notasF) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante");
        String nombre = sc.nextLine();
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equals(nombre)) {
                String primerParcial = "Primer Parcial = " + notas1[i];
                String segundoParcial = "Segundo Parcial = " + notas2[i];
                String examenFinal = "Examen Final = " + notasF[i];
                System.out.println(primerParcial);
                System.out.println(segundoParcial);
                System.out.println(examenFinal);
                break;
            }
        }
    }

    public static int sumar = 0;

    public static void agregarNotas(String[] nombres, int[] notas1, int[] notas2, int[] notasF) {
        for (int i = 0; i < nombres.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del estudiante");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la nota del primer parcial");
            int primerParcial = sc.nextInt();
            System.out.println("Ingrese la nota del segundo parcial");
            int segundoParcial = sc.nextInt();
            System.out.println("Ingrese la nota del exmaen final");
            int examenFinal = sc.nextInt();
            nombres[i] = nombre;
            notas1[i] = primerParcial;
            notas2[i] = segundoParcial;
            notasF[i] = examenFinal;
            sumar += notas1[i] + notas2[i] + notasF[i];
        }
    }

    public static void verPromedio(String[] nombres, int[] notas1, int[] notas2, int[] notasF) {
        float[] promedio = new float[nombres.length];
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante para ver su promedio");
        String nombre = sc.nextLine();
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equals(nombre)) {
                int sum = notas1[i] + notas2[i] + notasF[i];
                promedio[i] = (float) (sum / 3);
                System.out.println("El promedio de " + nombre + " es de " + promedio[i]);
                break;
            }
        }
    }

    public static void promedioDeMateria(int[] notas1) {
        float promedioDeMateria;
        promedioDeMateria = (float) sumar / (notas1.length * 3);
        System.out.println("El promedio de la materia es de " + promedioDeMateria);
    }

    public static void correrPrograma(String[] nombres, int[] notas1, int[] notas2, int[] notasF, int opcion) {
        while (opcion >= 0) {
        try {
                mostrarMenu();
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese una opcion");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        verNotas(nombres, notas1, notas2, notasF);
                        break;
                    case 2:
                        agregarNotas(nombres, notas1, notas2, notasF);
                        break;
                    case 3:
                        verPromedio(nombres, notas1, notas2, notasF);
                        break;
                    case 4:
                        promedioDeMateria(notas1);
                        break;
                    case 5:
                        opcion = -1;
                        System.out.println("Hasta pronto!, que tenga un buen dia");
                        break;
                    default:
                        System.out.println("No se encuentra la opcion ingresada, vuelva intentarlo por favor");
                        break;
                }
            }
         catch (Exception e) {
            System.out.println("Tiene que ser un numero entero para acceder a las opciones del programa, vuelva intentarlo por favor");
        }
        }
    }

}
