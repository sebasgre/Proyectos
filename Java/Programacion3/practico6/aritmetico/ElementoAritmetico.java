package Java.Programacion3.practico6.aritmetico;

import Java.Programacion3.practico6.Identificable;

public abstract class ElementoAritmetico implements Identificable {
    @Override
    public String getId() {
        return String.valueOf(this.hashCode());
    }
}
