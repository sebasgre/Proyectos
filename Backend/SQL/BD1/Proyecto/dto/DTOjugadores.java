package SQL.BD1.Proyecto.dto;

public class DTOjugadores {

    private int dni;
    private String nombre;
    private double sueldo;
    private String sexo;
    private String numDorsal;
    private String equipos_id;

    public DTOjugadores(int dni, String nombre, double sueldo, String sexo, String numDorsal, String equipos_id) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.sexo = sexo;
        this.numDorsal = numDorsal;
        this.equipos_id = equipos_id;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumDorsal() {
        return numDorsal;
    }

    public void setNumDorsal(String numDorsal) {
        this.numDorsal = numDorsal;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEquipos_id() {
        return equipos_id;
    }

    public void setEquipos_id(String equipos_id) {
        this.equipos_id = equipos_id;
    }

}
