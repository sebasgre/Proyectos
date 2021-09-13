package Java.demo.src.main.java.Programacion3.Practico3.Imagenes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import Java.demo.src.main.java.Programacion3.Practico3.Red.Enviar;


public class PanelImagen extends JPanel implements PropertyChangeListener, MouseListener {
    private Modelo modelo;
    private int x;
    private int y;
    private Enviar enviar;

    public PanelImagen(Modelo imagen) {
        modelo = imagen;
        addMouseListener(this);
    }

    public void setEnviar(Enviar enviar) {
        this.enviar = enviar;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null)
            modelo.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if(enviar != null){
            enviar.setPosX(x);
            enviar.setPosY(y);
            modelo.cambioOk();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
