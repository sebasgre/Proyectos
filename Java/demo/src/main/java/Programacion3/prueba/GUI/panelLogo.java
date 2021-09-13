package Java.demo.src.main.java.Programacion3.prueba.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelLogo extends JPanel {
    private Image imagen;

    public panelLogo() {
        imagen = new ImageIcon(
                "C:\\Users\\Sebastian\\OneDrive\\Documentos\\Visual Studio Code\\Proyectos\\Java\\Programacion3\\practico5\\Fotos\\logo.png")
                        .getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(465, 408);
    }

}
