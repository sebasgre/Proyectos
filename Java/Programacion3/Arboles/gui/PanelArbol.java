package Java.Programacion3.Arboles.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Java.Programacion3.Arboles.Arbol;
import Java.Programacion3.Arboles.Persona;

public class PanelArbol extends JPanel {
    private Arbol<Persona> modelo;

    public PanelArbol(Arbol<Persona> obj) {
        modelo = obj;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null) {
            DibujoArbol dibujoArbol = new DibujoArbol(modelo);
            dibujoArbol.dibujar(g);
        }
    }
}
