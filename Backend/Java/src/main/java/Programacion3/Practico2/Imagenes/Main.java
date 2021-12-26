package Programacion3.Practico2.Imagenes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        // Mi nombre es Sebastian
    }
}
