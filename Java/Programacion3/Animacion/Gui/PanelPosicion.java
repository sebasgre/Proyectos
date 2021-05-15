package Animacion.Gui;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Animacion.Modelo.Figura;

public class PanelPosicion extends JPanel implements PropertyChangeListener {

    private Figura modelo;
    private JLabel posicionLabel;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PanelPosicion(Figura f) {
        modelo = f;

        init();
    }

    private void init() {
        posicionLabel = new JLabel();
        this.setLayout(new BorderLayout());
        this.add(posicionLabel, BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        posicionLabel.setText("Posicion X,Y: " + modelo.getX() + "," + modelo.getY());
    }
}
