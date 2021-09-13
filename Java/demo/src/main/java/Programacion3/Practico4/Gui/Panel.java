package Java.demo.src.main.java.Programacion3.Practico4.Gui;


import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import Java.demo.src.main.java.Programacion3.Practico4.Vista.IDibujo;

public class Panel extends JPanel implements PropertyChangeListener {
    private final IDibujo dibujo;

    public Panel(IDibujo di) {
        dibujo = di;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 250);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujo.dibujo(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
