package SQL.BD1.Proyecto.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    private Panel panel;

    public Ventana() {
        init();
    }

    public void init() {
        panel = new Panel();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
