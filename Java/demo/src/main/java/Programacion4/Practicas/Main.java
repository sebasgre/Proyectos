package Java.demo.src.main.java.Programacion4.Practicas;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!"); --> C++
        /* System.out.println("Hello World!"); --> #C */
        /**
         * Esto es propio de Java
         */
        int b = 5;
        int c = 8;
        int a = b++ + c++;
        c += b++ + ++c;
        a += ++b + c++;
        b += ++a + ++c;
        System.out.println(a + "," + b + "," + c);
    }
}
