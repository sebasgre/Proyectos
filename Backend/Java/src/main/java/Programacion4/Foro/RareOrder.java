package Programacion4.Foro;

import java.util.Scanner;

public class RareOrder {
    private static String solution = "";
    private static boolean validar = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";

        boolean bandera = false;
        do {
            line = sc.nextLine();
            if (!line.equals("#"))
                order(line);
            else
                bandera = true;
        } while (!line.equals("#"));
        if (bandera)
            System.out.print(solution);
    }

    public static String order(String word) {
        if (validar) {
            solution += String.valueOf(word.charAt(0));
            validar = false;
            return solution;
        }

        for (int j = 0; j < word.length(); j++) {
            if (!solution.contains(String.valueOf(word.charAt(j)))) {
                solution += String.valueOf(word.charAt(j));
                break;
            }
        }
        return solution;
    }
}
