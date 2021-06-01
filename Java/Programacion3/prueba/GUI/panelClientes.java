package prueba.GUI;

import java.awt.Graphics;
import javax.swing.JPanel;

import prueba.Red.Enviar;
import prueba.Vista.iDibujo;

import java.awt.Dimension;
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
