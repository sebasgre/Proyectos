package SQL.BD1.Proyecto.dto;

import java.sql.Date;

public class DTOarbitros {
    private int dni;
    private String nombre;
    private double sueldo;
    private String sexo;
    private int peso;
    private Date f_nacimiento;
    private int altura;

    public DTOarbitros(int dni, String nombre, double sueldo, String sexo, int peso, Date f_nacimiento, int altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.sexo = sexo;
        this.peso = peso;
        this.f_nacimiento = f_nacimiento;
        this.altura = altura;
    }

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
