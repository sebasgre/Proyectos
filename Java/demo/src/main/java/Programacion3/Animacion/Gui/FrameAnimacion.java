package Java.demo.src.main.java.Programacion3.Animacion.Gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java.demo.src.main.java.Programacion3.Animacion.Modelo.Figura;
import Java.demo.src.main.java.Programacion3.Animacion.Vista.DibujoFigura;
import Java.demo.src.main.java.Programacion3.Animacion.Vista.IDibujo;

public class FrameAnimacion extends JFrame {
    private Figura modelo;
    private final static Logger logger = LogManager.getLogger();

    public FrameAnimacion() {
        modelo = new Figura();
        modelo.setX(100);
        modelo.setY(100);

        init();
    }

    private void init() {
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");

        JMenuItem item = new JMenuItem("Comenzar");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                archivo_comenzar();
            }
        });

        menu.add(item);

        bar.add(menu);
        this.setJMenuBar(bar);

        IDibujo dibujo = new DibujoFigura(modelo);
        PanelAnimacion panel = new PanelAnimacion(dibujo);

        PanelPosicion panelPosicion = new PanelPosicion(modelo);

        modelo.addObserver(panel);
        modelo.addObserver(panelPosicion);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(panelPosicion, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    protected void archivo_comenzar() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                mover200();
            }
        });

        thread.start();
    }

    protected void mover200() {
        for (int i = 0; i < 200; i++) {
            modelo.setX(modelo.getX() + 2);
            logger.info("Se esta moviendo en x " + modelo.getX());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }
        }
    }
}
