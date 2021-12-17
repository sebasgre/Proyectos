package SistemasOperativos1.FilosofosComensales.Consola;

import java.awt.*;

public class Consola {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
}
