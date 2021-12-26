package Programacion3.Practico4.Modelo;

import java.util.Comparator;

import Programacion3.Practico4.Lista.ComparadorPersona;

public class Persona implements Comparable<Persona> {
    private int edad;
    private int altura;
    private String nombre;
    private String genero;
    private Comparator<Persona> comparador;


    public Persona(String nombre, int edad, int altura,String genero) {
        this.edad = edad;
        this.altura = altura;
        this.nombre = nombre;
        this.genero = genero;
        this.comparador = new ComparadorPersona();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Comparator<Persona> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<Persona> comparador) {
        this.comparador = comparador;
    }

    @Override
    public int compareTo(Persona o) {
        // Si perro o es IGUAL a nosotros entonces devuelve 0
        // Si perro o viene ANTES que nosotros entonces devuelve -1
        // Si perro o viene DESPUES que nosotros entonces devuelve 1
        return comparador.compare(this, o);
    }
}
