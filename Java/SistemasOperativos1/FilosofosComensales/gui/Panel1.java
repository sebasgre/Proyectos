package Java.SistemasOperativos1.FilosofosComensales.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends JPanel {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private Font fuente1;
    private Font fuente2;

    public Panel1() {
        setBackground(Color.black);
        setLayout(null);
        cargarLabel();
    }

    public void cargarLabel() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        fuente1 = new Font("OnePlusSans", Font.BOLD, 32);
        fuente2 = new Font("OnePlusSans", Font.BOLD, 24);
        jLabel1.setText("UNIVERSIDAD NUR");
        jLabel1.setFont(fuente1);
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setText("Filosofos Comensales");
        jLabel2.setFont(fuente1);
        jLabel2.setForeground(Color.WHITE);
        jLabel3.setText("Luis Diego Condori Flores");
        jLabel3.setFont(fuente2);
        jLabel3.setForeground(Color.WHITE);
        jLabel4.setText("Sebastian Erwin Greiner Peña");
        jLabel4.setFont(fuente2);
        jLabel4.setForeground(Color.WHITE);
        jLabel1.setBounds(125, 50, 350, 30);
        jLabel2.setBounds(125, 100, 350, 30);
        jLabel3.setBounds(125, 180, 350, 30);
        jLabel4.setBounds(125, 230, 350, 30);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}
