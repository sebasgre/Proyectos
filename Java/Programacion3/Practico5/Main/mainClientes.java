package Practico5.Main;

import Practico5.GUI.ventanaUsuario;

public class mainClientes {
    public static void main(String[] args) {
        ventanaUsuario ventana = new ventanaUsuario();
        ventana.setTitle("Clientes");
        ventana.init();
        ventana.setVisible(true);
    }
}
