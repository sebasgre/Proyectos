package Programacion4.Ejercicios;

public class e1 {
    private static int a = 2;
    private static int b = 1;
    public static String generarSerie(int num) {
        // 2, 1, 5, 2, 8, 3, 11, 4, 14, 5
        String result = "";
        if (num <= 0) {
            return result;
        } else {
            num--;
        }
        if (num == 0) {
            result += a + ", " + b;
        } else {
            result += a + ", " + b + ", ";
        }
        a += 3;
        b++;
        return result + generarSerie(num);
    }

    public static void main(String[] args) {
        System.out.println(generarSerie(8));
    }
}
