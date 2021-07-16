package Java.Programacion3.practico7y8.modelo;

public abstract class ElementoAritmetico implements Identificable {

    @Override
    public String getId() {
        return String.valueOf(this.hashCode());
    }
}
