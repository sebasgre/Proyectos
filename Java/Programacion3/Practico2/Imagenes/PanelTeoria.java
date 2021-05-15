package Practico2.Imagenes;

import javax.swing.*;
import java.awt.*;

public class PanelTeoria extends JPanel {
    public String info() {
        return "<html><H4 align=center><br>FUNCIONALIDAD DEL EJERCICIO</H4><br><br>" +
                "<H4>1.- El programa permite cargar una imagen A de ancho y alto w y h respectivamente.</H4><br>" +
                "<H4>2.- Luego el programa permite cargar una imagen B que verifica que sea del mismo ancho<br> y alto w y h.</H4><br>" +
                "<H4>3.- Finalmente, el programa hace un merge de las dos imágenes.";
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}
