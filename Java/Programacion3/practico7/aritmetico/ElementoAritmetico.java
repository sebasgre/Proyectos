package Java.Programacion3.practico7.aritmetico;

import Java.Programacion3.practico7.gui.Identificable;

public abstract class ElementoAritmetico implements Identificable {
    @Override
    public String getId() {
        return String.valueOf(this.hashCode());
    }
}
