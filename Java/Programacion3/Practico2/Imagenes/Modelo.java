package Practico2.Imagenes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Modelo {
    private final int[][] pixeles;
    private final int ancho;
    private final int alto;
    private final PropertyChangeSupport observed;

    public Modelo(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observador) {
        observed.addPropertyChangeListener(observador);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setPixel(int c, int x, int y) {
        pixeles[x][y] = c;
    }

    public void dibujar(Graphics g) {
        BufferedImage rsm = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g2d.setColor(new Color(pixeles[i][j]));
                g2d.drawLine(i,j,i,j);
            }
        }
        g.drawImage(rsm,0,0,null);
    }

    public void cambioOk() {
        observed.firePropertyChange("Imagen", 1,2);
    }
}
