package Practico3.Red;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Practico3.Imagenes.Ventana;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}
