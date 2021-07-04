package Java.SistemasOperativos1.FilosofosComensales.Consola;

import Java.SistemasOperativos1.FilosofosComensales.gui.Frame;

public class Consola {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
}
