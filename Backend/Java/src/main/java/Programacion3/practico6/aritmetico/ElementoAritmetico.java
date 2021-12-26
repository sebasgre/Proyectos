package Programacion3.practico6.aritmetico;

import Programacion3.practico6.gui.Identificable;

public abstract class ElementoAritmetico implements Identificable {
    @Override
    public String getId() {
        return String.valueOf(this.hashCode());
    }
}
