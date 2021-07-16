package Java.Programacion3.practico7y8.dto;

public class DTOexpresion {

    private String nombre;
    private String expresion;

    public DTOexpresion(String nombre, String expresion) {
        this.nombre = nombre;
        this.expresion = expresion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
