package Programacion4.Grafos.main;

import Programacion4.Grafos.diccionario.ComparadorGenerico;
import Programacion4.Grafos.grafoconpeso.GrafoConPeso;

public class Main {

    public static void main(String[] args) {
//        Diccionario<String, Integer> dic1 =
//                new DiccionarioTablaHash<>();
//
//        dic1.insertar("A", 1);
//        dic1.insertar("V", 2);
//        dic1.insertar("X", 4);
//        dic1.insertar("P", 3);
//        dic1.insertar("R", 3);
//        dic1.insertar("T", 3);
//        dic1.insertar("12", 3);
//        dic1.insertar("M", 111);
//        dic1.insertar("B", 9);
//        dic1.insertar("M", 111);
//        dic1.insertar("C", 21);
//        dic1.insertar("Q", 9);
//        dic1.insertar("Z", 111);
//        dic1.insertar("RR", 9);
//        dic1.insertar("%%", 111);
//        dic1.insertar("ZZ", 111);
//        dic1.insertar("RRR", 9);
//        dic1.insertar("%%R", 111);
//
//
//        System.out.println();
//        System.out.println(dic1);
//        System.out.println();
//
//        System.out.println("V: " + dic1.obtener("V"));
//        System.out.println("H: " + dic1.obtener("H"));
//        System.out.println("B: " + dic1.obtener("B"));
//
//
//
//
//
//        System.out.println("contiene P?: " + dic1.contineLlave("P"));
//        System.out.println("contiene M?: " + dic1.contineLlave("M"));
//        System.out.println("Eliminando A:" + dic1.eliminar("A"));
//        System.out.println("Eliminando C:" + dic1.eliminar("C"));
//        System.out.println("Eliminando B:" + dic1.eliminar("B"));
//        System.out.println();
//        System.out.println(dic1);
//        System.out.println();
//
//        System.out.println(Arrays.toString(dic1.getLlaves().toArray(new String[0])));
//        System.out.println(Arrays.toString(dic1.getValores().toArray(new Integer[0])));


        GrafoConPeso<String, Integer, Integer> grafoConPeso = new GrafoConPeso<>(new ComparadorGenerico<>());
        grafoConPeso.insertarVertice("A", 2, 5);
        grafoConPeso.insertarVertice("B", 4, 6);
        grafoConPeso.insertarVertice("C", 6, 7);
        grafoConPeso.insertarVertice("D", 8, 8);
        grafoConPeso.insertarVertice("E", 10, 9);

        grafoConPeso.insertarArista("A", "B", 6);
        grafoConPeso.insertarArista("A", "C", 7);
        grafoConPeso.insertarArista("B", "D", 8);
        grafoConPeso.insertarArista("C", "E", 9);
        grafoConPeso.insertarArista("D", "C", 5);

        System.out.println(grafoConPeso);
        Integer eliminar = grafoConPeso.eliminarVertice("C");
        System.out.println("Se elimino: " + eliminar);

        System.out.println(grafoConPeso);
        System.out.print("El costo de la arista es: ");
        System.out.print(grafoConPeso.getCostoArista("A", "B"));

    }
}
