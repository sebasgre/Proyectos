package Java.demo.src.main.java.Programacion3.practico7y8.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Java.demo.src.main.java.Programacion3.practico7y8.controladores.ControladorBorrarDibujo;
import Java.demo.src.main.java.Programacion3.practico7y8.controladores.ControladorNuevaExpresion;
import Java.demo.src.main.java.Programacion3.practico7y8.modelo.ArbolAritmetico;

public class FrameArbol extends JFrame {

    private ArbolAritmetico modelo;
    private PanelArbol panelArbol;
    private PanelTablaExpresiones tablaExpresiones;
    private JTabbedPane pestañas;
    private Calculadora calculadora;

    public FrameArbol() {
        init();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void init() {
        setSize(1000, 600);
        modelo = null;
        pestañas = new JTabbedPane();
        pestañas.setBounds(0, 0, 1000, 600);
        panelArbol = new PanelArbol(modelo);
        calculadora = new Calculadora(panelArbol, modelo);
        tablaExpresiones = new PanelTablaExpresiones();
        tablaExpresiones.addObserver(panelArbol);
        panelArbol.addObserver(tablaExpresiones);
        panelArbol.addObserver(calculadora);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem nuevaExpresion = new JMenuItem("Ingresar Expresion");
        nuevaExpresion.addActionListener(new ControladorNuevaExpresion(modelo, panelArbol));
        JMenuItem borraExpresion = new JMenuItem("Borrar Dibujo");
        borraExpresion.addActionListener(new ControladorBorrarDibujo(panelArbol));

        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });

        JScrollPane scroller = new JScrollPane(panelArbol);
        pestañas.add("Arbol", scroller);
        pestañas.add("TablaExpresiones", tablaExpresiones);

        menu.add(nuevaExpresion);
        menu.add(borraExpresion);
        menu.add(salir);
        bar.add(menu);
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(pestañas, BorderLayout.CENTER);
    }

}
