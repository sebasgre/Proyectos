package Programacion4.Practico10.main;

import Programacion4.Practico10.diccionario.Diccionario;
import Programacion4.Practico10.diccionario.DiccionarioSecuencia;

public class Main {

    public static void main(String[] args) {
        Diccionario<Persona, Integer> dic1 =
                new DiccionarioSecuencia<>(new ComparadorPersonaV2());

        Persona p1 = new Persona("123456", "Luis Perez");
        Persona p2 =  new Persona("123456", "Juan Perez");
        Persona p3 = null;
        Persona p4 = new Persona("1477852", "Vinicius Jr");
        dic1.insertar(p1, 18);
        dic1.insertar(p2, 25);
        dic1.insertar(p3,26);
        dic1.insertar(p4,21);
        if(dic1.contineLlave(p2)){
            System.out.println("La persona existe");
        }else{
            System.out.println("La persona NO existe");
        }
        System.out.println(dic1.eliminar(p3));
        System.out.println(dic1.eliminar(p2));
        System.out.println(dic1.eliminar(p4));
        System.out.println(dic1.eliminar(p2));
        System.out.println(dic1.getCantidadElementos());

        System.out.println(dic1.obtener(p4));
        System.out.println(dic1.getLlaves());
        System.out.println(dic1.getValores());
        System.out.println(dic1.obtener(p2));
        //corregir eliminar

    }
}
