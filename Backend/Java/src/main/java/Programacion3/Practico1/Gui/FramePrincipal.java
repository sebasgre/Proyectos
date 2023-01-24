package Programacion3.Practico1.Gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import Programacion3.Practico1.Modelo.Linea;
import Programacion3.Practico1.Vista.DibujoLinea;
import Programacion3.Practico1.Vista.IDibujo;


public class FramePrincipal extends JFrame {
    private Linea[] lineas = new Linea[300];
    private final IDibujo dibujo = new DibujoLinea(lineas);
    private final Panel panel = new Panel(dibujo);

    public FramePrincipal() {
        init();
    }

    private void init() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem item1 = new JMenuItem("Crear Conjunto");
        JMenuItem item2 = new JMenuItem("Menor-Mayor");
        JMenuItem item3 = new JMenuItem("Mayor-Menor");
        item2.setEnabled(false);
        item3.setEnabled(false);
        item1.addActionListener(e -> {
            item2.setEnabled(true);
            item3.setEnabled(true);
            crearLineas();
        });

        item2.addActionListener(e -> {
            Thread thread = new Thread(() -> ordenarMenorMayor(lineas));
            thread.start();
        });

        item3.addActionListener(e -> {
            Thread thread = new Thread(() -> ordenarMayorMenor(lineas));
            thread.start();
        });

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        bar.add(menu);
        panel.setBackground(Color.BLACK);
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void crearLineas() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < lineas.length; i++) {
                try {
                    Linea li = new Linea();
                    li.addObserver(panel);
                    li.setX(i * 2);
                    lineas[i] = li;

                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void ordenarMenorMayor(Linea[] l) {
        for (int i = 0; i < lineas.length; i++) {
            for (int j = i + 1; j < lineas.length; j++) {
                if (lineas[i].getAlto() > lineas[j].getAlto()) {
                    int aux = lineas[i].getAlto();
                    lineas[i].setAlto(lineas[j].getAlto());
                    lineas[j].setAlto(aux);
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.lineas = l;
    }

    private void ordenarMayorMenor(Linea[] l) {
        for (int i = 0; i < lineas.length; i++) {
            for (int j = i + 1; j < lineas.length; j++) {
                if (lineas[i].getAlto() < lineas[j].getAlto()) {
                    int aux = lineas[j].getAlto();
                    lineas[j].setAlto(lineas[i].getAlto());
                    lineas[i].setAlto(aux);
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.lineas = l;
    }
}
