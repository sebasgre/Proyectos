package Lista;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> palabras = new ArrayList();
        palabras.add("Hugo");
        palabras.add("Paco");
        palabras.add("Luis");

        System.out.println(palabras);

        Lista testLista = new Lista();
        testLista.insertar("hugo");
        testLista.insertar("Paco");
        testLista.insertar("Luis");
        System.out.println("Lista2 con Contenedor: " + testLista);

        Lista2<String> a = new Lista2<>();
        a.insertar("hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        System.out.println("Nuestra Lista2: " + a);
        System.out.println("Tamano: " + a.getTamano());

        Lista2<String> b = new Lista2<>();
        b.add("Hugo");
        b.add("Paco");
        b.add("Luis");
        b.add("Sebastian");
        b.add("Jose");
        System.out.println("Nuestra Lista2: " + b);
        System.out.println("Tamano: " + b.getTamano());
    }
}
