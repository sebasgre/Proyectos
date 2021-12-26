package Programacion4.Practico5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Longitudes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineas = Integer.parseInt(br.readLine());
        for (int i = 0; i < lineas; i++) {
            String linea = br.readLine(); // manzana es de color rojo
            String[] cadena = linea.split(" ");
            String[] cadenaOrdenada = ordenar(cadena);
            String espacio = "";
            StringBuilder sb = new StringBuilder();
            for (String ca : cadenaOrdenada) {
                sb.append(espacio).append(ca);
                espacio = " ";
            }
            System.out.println(sb);
        }
    }

    private static String[] ordenar(String[] cadena) {
        String guardado;
        for (int i = 0; i < cadena.length - 1; i++) {
            for (int j = 0; j < cadena.length - 1; j++) {
                if (cadena[j].length() < cadena[j + 1].length()) {
                    guardado = cadena[j];
                    cadena[j] = cadena[j + 1];
                    cadena[j + 1] = guardado;
                }
            }
        }
        return cadena;
    }
}
