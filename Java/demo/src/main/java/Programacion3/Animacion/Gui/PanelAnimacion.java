package Programacion3.Animacion.Gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import Programacion3.Animacion.Vista.IDibujo;

public class PanelAnimacion extends JPanel implements PropertyChangeListener {

    private IDibujo dibujo;

    public PanelAnimacion(IDibujo dibujo) {
        this.dibujo = dibujo;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dibujo != null) {
            dibujo.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
