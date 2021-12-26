package Programacion4.ArbolAVL.main;

import java.util.Arrays;
import java.util.List;

import Programacion4.ArbolBusqueda.abb.ArbolBinarioBusqueda;

public class MainAbb2 {

    public static void main(String[] args) {

        ArbolBinarioBusqueda<Double> abb = new ArbolBinarioBusqueda<>();
        abb.insertar(26.0,12.0,38.0,18.0,29.0,8.0,42.0,10.0,32.0,35.0,30.0,15.0);

        recorridoInOrden(abb);

        abb.eliminar(12.0, 35.0);
        System.out.println();
        recorridoInOrden(abb);

    }

    private static void recorridoInOrden(ArbolBinarioBusqueda<Double> abb ){
        List<Double> list = abb.getRecorridoInOrden();
        Double[] elements = list.toArray(new Double[0]);

        System.out.println("Recorrido In-Orden");
        System.out.println(Arrays.toString(elements));

    }
}
