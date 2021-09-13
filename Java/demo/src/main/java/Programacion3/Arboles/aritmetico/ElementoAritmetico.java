package Java.demo.src.main.java.Programacion3.Arboles.aritmetico;

import Java.demo.src.main.java.Programacion3.Arboles.Identificable;

public abstract class ElementoAritmetico implements Identificable {
    @Override
    public String getId() {
        return String.valueOf(this.hashCode());
    }
}
