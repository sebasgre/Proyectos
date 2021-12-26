package Programacion4.ArbolBusqueda.main;

import java.util.Arrays;
import java.util.List;

import Programacion4.ArbolBusqueda.abb.ArbolBinarioBusqueda;

public class MainAbb {
    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer> abb = new ArbolBinarioBusqueda<>();
        //abb.insertar(50,10,80,5,20,70,25,60,75);
        abb.insertar(26,12,38,18,29,8,42,10,32,35,30,15);
        // abb.insertar(6,2,5,15,1);
        List<Integer> list = abb.getRecorridoInOrden();
        Integer[] elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido In-Orden");
        System.out.println(Arrays.toString(elements));
        System.out.println(Arrays.toString(abb.getRecorridoInOrden().toArray(new Integer[0])));

        list = abb.getRecorridoPreOrden();
        elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido Pre-Orden");
        System.out.println(Arrays.toString(elements));

        list = abb.getRecorridoPostOrden();
        elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido Post-Orden");
        System.out.println(Arrays.toString(elements));

        list = abb.getRecorridoPorNiveles();
        elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido Por Niveles");
        System.out.println(Arrays.toString(elements));

        list = abb.getRamaMasLarga();
        elements = list.toArray(new Integer[0]);

        System.out.println("Rama mas larga");
        System.out.println(Arrays.toString(elements));

        System.out.println("Peso: " + abb.getPeso());
        System.out.println("Altura: " + abb.getAltura());
        System.out.println("12: " + abb.buscar(12));
    }
}
