package SistemasOperativos1.FilosofosComensales.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel2 extends JPanel {
    private Image imagen;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 360);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imagen = new ImageIcon(getClass().getClassLoader().getResource("Java/SistemasOperativos1/Imagenes/filosofos.png")).getImage();
        g.drawImage(imagen, 0, 0, 465, 361, this);
        //setOpaque(false);
    }
}
