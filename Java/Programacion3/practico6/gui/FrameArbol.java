package Java.Programacion3.practico6.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Java.Programacion3.practico6.aritmetico.ArbolAritmetico;

public class FrameArbol extends JFrame {
    private static ArbolAritmetico modelo;

    public FrameArbol(ArbolAritmetico obj) {
        modelo = obj;
        init();
    }

    private void init() {
        PanelArbol panel = new PanelArbol(modelo);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem item1 = new JMenuItem("Nueva expresión:");
        item1.addActionListener(e -> {
            try {
                String expresión = JOptionPane.showInputDialog(null, "Ingrese la expresion");
                modelo = new ArbolAritmetico(expresión);
                panel.setModelo(modelo);
                modelo.addObserver(panel);
                modelo.cambioOk();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        
        menu.add(item1);
        bar.add(menu);
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            FrameArbol frameArbol = new FrameArbol(modelo);
            frameArbol.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
