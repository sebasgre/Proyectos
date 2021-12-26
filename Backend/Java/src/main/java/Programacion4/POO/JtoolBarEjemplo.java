package Programacion4.POO;

import javax.swing.*;
import java.awt.*;

public class JtoolBarEjemplo extends JFrame {

    private final JPanel panel = new JPanel();
    private final JToolBar toolBar = new JToolBar();
    private final JButton btnAbrir = new JButton("Abrir");
    private final JButton btnGuardar = new JButton("Guardar");

    public JtoolBarEjemplo() {
        setTitle("Mi ventana");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        toolBar.add(btnAbrir);
        toolBar.add(btnGuardar);
        add(toolBar, BorderLayout.NORTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JtoolBarEjemplo();
    }
}
