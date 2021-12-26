package Programacion4.Practico11.main;

import Programacion4.Practico11.diccionario.Comparador;

public class Persona {

    private String ci;
    private String nombre;

    public Persona(String ci, String nombre) {
        this.ci = ci;
        this.nombre = nombre;
    }

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

    public static void main(String[] args) {
        Persona p1 = new Persona("123456", "Luis Perez");
        Persona p2 = new Persona("123456", "Juan Perez");

        Comparador<Persona> c1 = getComparadorPersona();

        if(c1.esIgual(p1, p2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("NO son iguales");
        }

    }

    public static Comparador<Persona> getComparadorPersona(){
        return new ComparadorPersonaV2();
    }
}
