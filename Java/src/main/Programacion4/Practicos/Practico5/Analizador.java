package Programacion4.Practicos.Practico5;

import java.io.IOException;
import java.util.Scanner;

public class Analizador {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String line = sc.nextLine();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    String caracter = String.valueOf(line.charAt(i)).toLowerCase();
                    if (caracter.equals("o")) {
                        sb.append(0);
                    }
                    if (caracter.equals("l")) {
                        sb.append(1);
                    }
                    if (caracter.matches("[0-9]")) {
                        sb.append(caracter);
                    }
                }
                System.out.println(line.isEmpty() ? "error" : Integer.parseInt(sb.toString()));
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}
