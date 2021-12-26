package Programacion4.Practico9;

public class Main {
    public static void main(String[] args) {
        Lista<String> list = new Lista<>();
        list.insertar("Hola");
        list.insertar("como");
        list.insertar("estas");
        System.out.println(list.toString()); //Debe imprimir Hola, como, estas
        String str = list.get(1);
        System.out.println(str); //Debe imprimir el valor: como
        list.eliminar(1); //Debe eliminar el elemento en la posición 1
        System.out.println(list.toString()); //Debe imprimir Hola, estas
    }
}
