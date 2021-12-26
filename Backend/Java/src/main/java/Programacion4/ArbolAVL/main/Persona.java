package Programacion4.ArbolAVL.main;

public class Persona implements Comparable<Persona>{

    private int edad;
    private double peso;

    public Persona(int edad, double peso) {
        this.edad = edad;
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona o) {
        return edad - o.edad;
    }
}
