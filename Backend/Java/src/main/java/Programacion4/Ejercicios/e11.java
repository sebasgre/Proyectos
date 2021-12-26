package Programacion4.Ejercicios;


public class e11 {
    public static void main(String[] args) {
        System.out.println(contadorDeVocales("Fruta"));
    }

    public static int contador = 0;

    public static String contadorDeVocales(String palabra) {
        String solucion = "";

        if (palabra.length() == 0) {
            if (contador > 1) {
                solucion = "Tiene " + contador + " vocales";
            } else {
                solucion = "Tiene " + contador + " vocal";
            }
            return solucion;
        }
        if (palabra.toLowerCase().charAt(0) == 'a' || palabra.toLowerCase().charAt(0) == 'e' || palabra.toLowerCase().charAt(0) == 'i' || palabra.toLowerCase().charAt(0) == 'o' || palabra.toLowerCase().charAt(0) == 'u') {
            contador++;
        }
        return contadorDeVocales(palabra.substring(1));
    }
}
