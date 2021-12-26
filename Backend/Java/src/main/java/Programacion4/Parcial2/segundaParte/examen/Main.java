package Programacion4.Parcial2.segundaParte.examen;



import java.util.Arrays;

import Programacion4.Parcial2.segundaParte.abb.ArbolBinarioBusqueda;

public class Main {

    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer> a = new ArbolBinarioBusqueda<>();
        a.insertar(15,6,20,3,9,18,24,17,4,1,7,12);
        System.out.println(Arrays.toString(a.getRecorridoHasta(9).toArray()));
        System.out.println(Arrays.toString(a.getRecorridoHasta(17).toArray()));
        System.out.println(Arrays.toString(a.getRecorridoHasta(20).toArray()));
        System.out.println(Arrays.toString(a.getRecorridoHasta(55).toArray()));
        System.out.println(Arrays.toString(a.getRecorridoHasta(1).toArray()));
    }
}
