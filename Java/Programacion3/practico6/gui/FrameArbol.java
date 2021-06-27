package Java.Programacion3.practico6.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Java.Programacion3.practico6.modelo.ArbolAritmetico;

public class FrameArbol extends JFrame {
    private static ArbolAritmetico modelo;
    private PanelArbol panel;

    public FrameArbol(ArbolAritmetico obj) {
        modelo = obj;
        init();
    }

    private void init() {
        this.setSize(600, 400);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item1 = new JMenuItem("Ingresar Expresion:");
        item1.addActionListener(e -> {
            try {
                String expresión = JOptionPane.showInputDialog(null, "Ingrese la expresion:");
                if (expresión == null)
                    return;
                modelo = new ArbolAritmetico(expresión);
                modelo.addObserver(panel);
                panel.setModelo(modelo);
                modelo.cambioOk();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        panel = new PanelArbol(modelo);
        JScrollPane scroller = new JScrollPane(panel);
        menu.add(item1);
        bar.add(menu);
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(scroller, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
