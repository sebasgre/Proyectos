package Programacion4.Parcial2.primeraParte;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Programacion4.Diccionario.diccionario.DiccionarioTablaHash;

public class Pregunta1 {
    public ArrayList<Integer> resolver(InputStream in) {
        ArrayList<Integer> result = new ArrayList<>();
        DiccionarioTablaHash<Integer,Integer> table;
        Scanner sc = new Scanner(in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            table = new DiccionarioTablaHash<>();
            int count = 0;
            String line = sc.nextLine();
            int size = line.split(" ").length;
            for (int k = 0; k < size; k++) {
                int value = Math.abs(Integer.parseInt(line.split(" ")[k]));
                if (table.contineLlave(value) == false) {
                    table.insertar(value,value);
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int size = line.split(" ").length;
        // 40 50 99 115
        System.out.println("Esto me devuelve el tamaño por linea en cada entrada");
        System.out.println(size);
        System.out.println("Aqui obtengo el valor de un elemento cualquiera en una determinada posicion");
        System.out.println(line.split(" ")[2]);
        List<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(5);
        myArrayList.add(4);
        myArrayList.add(8);
        myArrayList.add(10);
        myArrayList.add(1);
        System.out.println(myArrayList.get(2));
        System.out.println("Esto me devuelve el tamaño de mi ArrayList: " + myArrayList.size());
        //myArrayList.sort();
        Collections.sort(myArrayList);
        System.out.println(myArrayList);
        Collections.sort(myArrayList, Collections.reverseOrder());
        System.out.println(myArrayList);
        System.out.println(myArrayList.remove(3));
    }
}
