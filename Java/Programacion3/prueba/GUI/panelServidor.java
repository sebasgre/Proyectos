package prueba.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import prueba.Vista.iDibujo;

public class panelServidor extends JPanel implements PropertyChangeListener {
    private iDibujo dibujo;

    public panelServidor(iDibujo di) {
        dibujo = di;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
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
