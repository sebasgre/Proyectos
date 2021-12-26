package Programacion4.ArbolAVL.main;

import java.util.Comparator;

import Programacion4.ArbolBusqueda.abb.ArbolBinarioBusqueda;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona(15, 80);
        Persona p2 = new Persona(20, 75);

        Comparator<Persona> comparator = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getPeso() == o2.getPeso() ? 0 :
                        o1.getPeso() > o2.getPeso() ? 1 : -1;
            }
        };


        ArbolBinarioBusqueda<Persona> abb =
                new ArbolBinarioBusqueda<>(comparator);



       // System.out.println(abb.comparar(p1, p2));
    }
}
