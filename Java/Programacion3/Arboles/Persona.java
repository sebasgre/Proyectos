package Arboles;

public class Persona implements Identificable {
    private String ci;
    private String nombre;

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String ci, String nombre) {
        this.ci = ci;
        this.nombre = nombre;
    }

    @Override
    public String getId() {
        return ci;
    }
}
