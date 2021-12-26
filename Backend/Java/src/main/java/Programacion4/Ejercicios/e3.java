package Programacion4.Ejercicios;

import javax.swing.*;



public class e3 {
    public static void main(String[] args) {
        //Esto es opcional
        int size;
        String mensaje = JOptionPane.showInputDialog("Ingrese el tamaño del vector");
        size = Integer.parseInt(mensaje);
        int[] num = new int[size];

        //Invocamos las funciones
        rellenarArray(num);
        mostrarArray(num);
    }

    public static void rellenarArray(int[] lista){
        for(int i=0;i<lista.length;i++){
            String texto= JOptionPane.showInputDialog("Introduce un número");
            lista[i]=Integer.parseInt(texto);
        }
    }

    public static void mostrarArray(int[] lista){
        for(int i=0;i<lista.length;i++){
            System.out.println("En el indice "+i+" esta el valor "+lista[i]);
        }
    }


}
