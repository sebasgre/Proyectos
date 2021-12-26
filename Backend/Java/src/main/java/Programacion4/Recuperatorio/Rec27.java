package Programacion4.Recuperatorio;

import java.util.Scanner;

public class Rec27 {
    public static void main(String[] args) {
        float N1, N2, N3, N4, average, N5, recalaverage;
        Scanner input = new Scanner(System.in);
        N1 = input.nextFloat();
        N2 = input.nextFloat();
        N3 = input.nextFloat();
        N4 = input.nextFloat();

        average = ((N1 * 2) + (N2 * 3) + (N3 * 4) + (N4 * 1)) / 10;

        if (average >= 7.0) {

            System.out.printf("Media: %.1f\n", average);
            System.out.print("Aluno aprovado.\n");

        } else if (average >= 5.0 && average <= 6.9) {

            System.out.printf("Media: %.1f\n", average);
            System.out.print("Aluno em exame.\n");
            N5 = input.nextFloat();
            System.out.printf("Nota do exame: %.1f\n", N5);
            recalaverage = (average + N5) / 2;

            if (recalaverage >= 5.0) {
                System.out.print("Aluno aprovado.\n");

            } else {
                System.out.print("Aluno reprovado.\n");

            }

            System.out.printf("Media final: %.1f\n", recalaverage);

        } else if (average < 5.0) {

            System.out.printf("Media: %.1f\n", average);
            System.out.print("Aluno reprovado.\n");

        }
    }
}

