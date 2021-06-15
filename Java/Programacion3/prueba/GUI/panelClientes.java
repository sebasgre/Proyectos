package Java.Programacion3.prueba.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import Java.Programacion3.prueba.Red.Enviar;
import Java.Programacion3.prueba.Vista.iDibujo;

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
