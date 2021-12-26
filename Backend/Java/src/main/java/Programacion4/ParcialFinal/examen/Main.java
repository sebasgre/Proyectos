package Programacion4.ParcialFinal.examen;

import Programacion4.ParcialFinal.abb.ArbolBinarioBusqueda;

public class Main {

    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer> a = new ArbolBinarioBusqueda<>();
        a.insertar(15,6,20,3,9,18,24,17,4,1,7,12);
        System.out.println(a.getAncestroComun(6,20));
        System.out.println(a.getAncestroComun(20,6));
        System.out.println(a.getAncestroComun(3,12));
        System.out.println(a.getAncestroComun(17,24));
        System.out.println(a.getAncestroComun(1,15));
        System.out.println(a.getAncestroComun(6,12));
        System.out.println(a.getAncestroComun(1,6));
        System.out.println(a.getAncestroComun(17,18));
        System.out.println(a.getAncestroComun(9,17));
        System.out.println(a.getAncestroComun(6,30));
//        System.out.println("Por niveles");
//        System.out.println(a.getRecorridoPorNiveles());
//        System.out.println("In order");
//        System.out.println(a.getRecorridoInOrden());
//        System.out.println("Post order");
//        System.out.println(a.getRecorridoPostOrden());
//        System.out.println("Pre order");
//        System.out.println(a.getRecorridoPreOrden());
    }
}
