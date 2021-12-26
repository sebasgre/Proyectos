package Programacion4.Practico12;

public class Automovil {
    private String matricula;
    private double velocidad;

    public Automovil(String matricula, double velocidad) {
        this.matricula = matricula;
        this.velocidad = velocidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public Automovil(String matricula) {
        this.matricula = matricula;
    }
}
