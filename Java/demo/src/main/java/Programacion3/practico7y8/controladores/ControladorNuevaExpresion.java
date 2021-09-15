package Programacion3.practico7y8.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Programacion3.practico7y8.gui.PanelArbol;
import Programacion3.practico7y8.modelo.ArbolAritmetico;

public class ControladorNuevaExpresion implements ActionListener {

    private  final static Logger logger = LogManager.getLogger();

    private ArbolAritmetico modelo;
    private PanelArbol panel;

    public ControladorNuevaExpresion(ArbolAritmetico modelo, PanelArbol panel) {
        this.modelo = modelo;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JTextField expresion = new JTextField();
            Object[] message = {"Expresion: ", expresion};
            int option = JOptionPane.showConfirmDialog(null, message, "Nueva Expresion", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (expresion.getText().equals("") && !expresion.getText().matches("[a-zA-Z]")) {
                    String mensaje = expresion.getText().equals("") ? "Ingrese una expresion" : "Ingrese una expresion solo numeros";
                    JOptionPane.showMessageDialog(null, mensaje);
                    return;
                }
                modelo = new ArbolAritmetico(expresion.getText());
                modelo.addObserver(panel);
                panel.setModelo(modelo);
                modelo.cambioOk();
                logger.info("Nueva expresion: " + expresion.getText());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
