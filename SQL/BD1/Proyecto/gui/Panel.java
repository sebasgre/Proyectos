package SQL.BD1.Proyecto.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {
    private Image imagen;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imagen = new ImageIcon(getClass().getClassLoader().getResource("SQL/BD1/Proyecto/gui/gif/champions.gif"))
                .getImage();
        g.drawImage(imagen, 0, 0, 600, 400, this);
    }

}
