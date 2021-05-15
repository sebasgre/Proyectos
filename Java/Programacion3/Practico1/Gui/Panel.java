package Practico1.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import Practico1.Vista.IDibujo;

public class Panel extends JPanel implements PropertyChangeListener {
    private IDibujo dibujo;

    public Panel(IDibujo di) {
        dibujo = di;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dibujo != null) {
            g.setColor(Color.WHITE);
            dibujo.dibujo(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
