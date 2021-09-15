package Programacion3.practico7y8.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Programacion3.practico7y8.gui.PanelArbol;

public class ControladorBorrarDibujo implements ActionListener {

    private PanelArbol panel;

    public ControladorBorrarDibujo(PanelArbol panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panel.getModelo() == null)
            return;
        panel.getModelo().setRaiz(null);
        // panel.setModelo(panel.getModelo());
        panel.getModelo().cambioOk();
    }
}
