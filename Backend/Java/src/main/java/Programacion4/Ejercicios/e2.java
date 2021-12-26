package Programacion4.Ejercicios;

public class e2 {
    public static String nombreNumeros (String str, int indice) {
        String palabra = "";
        if (str.length() == 0) {
            return str;
        }
        palabra += str.charAt(0) + String.valueOf(indice);
        indice++;
        return palabra + nombreNumeros(str.substring(1), indice);
    }

    public static void main(String[] args) {
        System.out.println(nombreNumeros("Eduardo", 1));
    }
}
