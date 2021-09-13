package Java.demo.src.main.java.Programacion3.Arboles;

public class TestArbol {
    public static void main(String[] args) {
        Arbol<Persona> a = new Arbol();

        a.addHijo(new Persona("A", "Hugo"), null);
        a.addHijo(new Persona("B", "Paco"), "A");
        a.addHijo(new Persona("C", "Paco"), "A");
        a.addHijo(new Persona("D", "Paco"), "A");
        a.addHijo(new Persona("E", "Paco"), "C");
        a.addHijo(new Persona("F", "Paco"), "D");
        a.addHijo(new Persona("G", "Paco"), "B");
        a.addHijo(new Persona("H", "Paco"), "B");
        
        System.out.println(a);
    }
}
