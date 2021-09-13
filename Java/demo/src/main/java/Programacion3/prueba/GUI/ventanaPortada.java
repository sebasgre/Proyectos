package Java.demo.src.main.java.Programacion3.prueba.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ventanaPortada extends JFrame {
    private panelLogo panelLogo = new panelLogo();
    
    
    public ventanaPortada() {
        initLogo();
    }

    public void initLogo() {
        panelLogo.setLayout(null);
        JButton btnContinuar = new JButton();
        btnContinuar.setBounds(415, 358, 50, 50);
        ImageIcon image = new ImageIcon(
                "C:\\Users\\Sebastian\\OneDrive\\Documentos\\Visual Studio Code\\Proyectos\\Java\\Programacion3\\practico5\\Fotos\\continuar.png");
        btnContinuar.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnContinuar.getWidth(),
                btnContinuar.getHeight(), image.getImageLoadStatus())));
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(null);
        panelLogo.add(btnContinuar);
        
        btnContinuar.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambioPanel();
                Ventana ventana = new Ventana();
                //ventana.initServidor();
                ventana.setVisible(true);
            }
        });

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelLogo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    

    public void cambioPanel() {
        this.setVisible(false);
    }
}
