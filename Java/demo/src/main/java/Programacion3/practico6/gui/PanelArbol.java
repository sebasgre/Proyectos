package Programacion3.practico6.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Programacion3.practico6.Arbol.Arbol;
import Programacion3.practico6.aritmetico.ElementoAritmetico;
import Programacion3.practico6.aritmetico.Numero;
import Programacion3.practico6.aritmetico.Operador;
import Programacion3.practico6.modelo.ArbolAritmetico;
import Programacion3.practico6.view.DibujoArbol;

public class PanelArbol extends JPanel implements MouseListener, PropertyChangeListener {

    private ArbolAritmetico modelo;
    private final static Logger logger = LogManager.getLogger();

    public PanelArbol(ArbolAritmetico obj) {
        modelo = obj;
        this.addMouseListener(this);
        this.setBackground(Color.BLACK);
    }

    public Dimension getPreferredSize() {
        return new Dimension(10000, 10000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null) {
            DibujoArbol dibujoArbol = new DibujoArbol(modelo);
            dibujoArbol.dibujo(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (modelo == null)
            return;
        Arbol.Contenedor<ElementoAritmetico> raiz = modelo.getRaiz();
        Arbol.Contenedor<ElementoAritmetico> seleccionado = accederPosicion(raiz, e);
        ArbolAritmetico prueba = null;
        try {
            if (seleccionado != null) {
                prueba = new ArbolAritmetico(toStringAritmetico(seleccionado));
                prueba.setRaiz(seleccionado);
                String operacion = prueba.toString();
                JOptionPane.showMessageDialog(null, operacion);
                logger.debug("Aqui mostramos la operacion realizada");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Arbol.Contenedor<ElementoAritmetico> accederPosicion(Arbol.Contenedor<ElementoAritmetico> contenedor,
            MouseEvent e) {
        Arbol.Contenedor<ElementoAritmetico> seleccionado = null;
        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            seleccionado = accederPosicion(hijo, e);
            if (seleccionado != null) {
                break;
            }
        }

        if (e.getX() >= contenedor.getPosX() && e.getX() <= (contenedor.getPosX() + 40)
                && e.getY() >= contenedor.getPosY() && e.getY() <= (contenedor.getPosY() + 40)) {
                    logger.debug("Aqui se muestra el posicionamiento del nodo " + e.getX() + " | " + e.getY());
            return contenedor;
        }

        return seleccionado;
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    public ArbolAritmetico getModelo() {
        return modelo;
    }

    public void setModelo(ArbolAritmetico modelo) {
        this.modelo = modelo;
    }

    public String toStringAritmetico(Arbol.Contenedor<ElementoAritmetico> nodo) {
        ElementoAritmetico elementoAritmetico = nodo.getContenido();
        if (elementoAritmetico instanceof Numero) {
            return String.valueOf(((Numero) elementoAritmetico).getValor());
        }

        Operador operacion = (Operador) elementoAritmetico;
        String operacionString = operacion.getSimbolo();

        StringBuilder resultado = new StringBuilder();
        String separador = "";
        for (Arbol.Contenedor<ElementoAritmetico> hijo : nodo.getHijos()) {
            String hijoString = toStringAritmetico(hijo);
            resultado.append(separador).append(hijoString);
            separador = operacionString;
        }
        return resultado.toString();
    }
}
