package Programacion3.Practico3.Red;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Programacion3.Practico3.Imagenes.Ventana;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
