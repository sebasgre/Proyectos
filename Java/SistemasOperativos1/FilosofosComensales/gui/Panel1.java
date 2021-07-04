package Java.SistemasOperativos1.FilosofosComensales.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel1 extends JPanel {
    
    private Image imagen;

    public Panel1() {
        this.setLayout(null);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imagen = new ImageIcon(
                getClass().getClassLoader().getResource("Java/SistemasOperativos1/Imagenes/fondo comensales.png")).getImage();
        g.drawImage(imagen, 0, 0, 600, 400, this);
    }
}
