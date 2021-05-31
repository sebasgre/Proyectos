package Practico5.GUI;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;

import Practico5.Red.Enviar;
import Practico5.Vista.iDibujo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class panelClientes extends JPanel implements PropertyChangeListener {
    private iDibujo dibujo;
    private Enviar enviar;
    
    public panelClientes(iDibujo di) {
        dibujo = di;
    }
    
    public void setEnviar(Enviar enviar) {
        this.enviar = enviar;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
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
