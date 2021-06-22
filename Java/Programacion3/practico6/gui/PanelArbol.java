package Java.Programacion3.practico6.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import Java.Programacion3.practico6.aritmetico.ArbolAritmetico;

public class PanelArbol extends JPanel implements MouseListener, PropertyChangeListener {
    private ArbolAritmetico modelo;
    private int x;
    private int y;

    public ArbolAritmetico getModelo() {
        return modelo;
    }

    public void setModelo(ArbolAritmetico modelo) {
        this.modelo = modelo;
    }

    public PanelArbol(ArbolAritmetico obj) {
        modelo = obj;
        addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        System.out.println(x + " | " + y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO Auto-generated method stub
        repaint();
    }

}
