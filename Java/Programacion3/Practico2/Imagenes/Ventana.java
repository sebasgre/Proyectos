package Java.Programacion3.Practico2.Imagenes;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java.Programacion3.Practico2.ImagenesTransformadas.Imagenes;


public class Ventana extends JFrame {
    private final Modelo modelo = new Modelo(600, 400);
    private final PanelImagen panel = new PanelImagen(modelo);
    private final Imagenes imagenes = new Imagenes(modelo);
    private final static Logger logger = LogManager.getLogger();

    public Ventana() {
        init();
    }

    public void init() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem item1 = new JMenuItem("Cargar imagen 1");
        JMenuItem item2 = new JMenuItem("Cargar imagen 2");
        JMenuItem item3 = new JMenuItem("Imagen resultante");
        JMenuItem item4 = new JMenuItem("Ayuda");

        modelo.addObserver(panel);

        item1.addActionListener(e -> mnuImagen1());
        item2.addActionListener(e -> mnuImagen2());
        item3.addActionListener(e -> mnuImagen3());
        item4.addActionListener(e -> ayuda());

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        bar.add(menu);

        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    protected void mnuImagen1() {
        imagenes.hacer1();
        logger.info("Aqui se carga la imagen 1");
    }

    protected void mnuImagen2() {
        imagenes.hacer2();
        logger.info("Aqui se carga la imagen 2");
    }

    protected void mnuImagen3() {
        imagenes.hacer3();
        logger.info("Aqui se carga la imagen resultante");
    }

    protected void ayuda() {
        PanelTeoria teoria = new PanelTeoria();
        this.remove(panel);
        teoria.add(new JLabel(teoria.info()));
        this.getContentPane().add(teoria, BorderLayout.CENTER);
        JButton btnVolver = new JButton("Volver");
        this.getContentPane().add(btnVolver, BorderLayout.NORTH);
        btnVolver.addActionListener(e -> {
            remove(teoria);
            remove(btnVolver);
            add(panel, BorderLayout.CENTER);
            validate();
            repaint();
        });
        this.validate();
        logger.info("Aqui se muestra el mensaje al usuario, sobre el ejercicio realizado");
    }

}

