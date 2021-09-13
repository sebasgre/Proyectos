package Java.demo.src.main.java.Programacion3.practico6.aritmetico;

public class Operador extends ElementoAritmetico {

    private String simbolo;
    private String nombre;

    public Operador(String s) {
        simbolo = s;
        if (s.equals("+")) {
            nombre = "Suma";
        }

        if (s.equals("-")) {
            nombre = "Resta";
        }

        if (s.equals("*")) {
            nombre = "Multiplica";
        }

        if (s.equals("/")) {
            nombre = "Divide";
        }
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

}