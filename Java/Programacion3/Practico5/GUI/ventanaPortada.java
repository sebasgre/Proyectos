package Practico5.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Practico5.Lista.Lista;
import Practico5.Modelo.Mensaje;
import Practico5.Red.Enviar;
import Practico5.Red.Recibir;

public class ventanaPortada extends JFrame {
    private panelLogo panelLogo = new panelLogo();
    private Enviar conexion;
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
                esperarConexion();
                cambioPanel();
                Ventana ventana = new Ventana();
                ventana.initServidor();
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

    private void esperarConexion() {
        int puerto = 1452;
        if (leerPuerto(puerto) != 0) {
            int port = puerto;
            try {
                if (port <= 1024 || port > 65000) {
                    throw new Exception("Debe colocar un entero");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Debe colocar un número entero positivo mayor a 1024, intente de nuevo por favor");
                return;
            }

            Recibir recibir;
            try {
                recibir = new Recibir(port);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Hubo un error al crear/esperar la conexión, trate con otro puerto");
                return;
            }

            try {
                conexion = new Enviar(recibir.getClt());
                // panelImagen.setEnviar(conexion);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Hubo un error al crear el objeto para enviar, trate de nuevo");
                return;
            }

            Thread recibiendo = new Thread(recibir);
            recibiendo.start();
            añadirObservador();
        }
    }

    private int leerPuerto(int puerto) {
        int n = puerto;
        try {
            if (n < 1024 || n > 65535)
                return 0;
        } catch (Exception e) {
            return 0;
        }
        return n;
    }

    private void añadirObservador() {
        Lista<Mensaje> lista = new Lista();
        lista.addObserver(conexion);
    }

    public void cambioPanel() {
        this.setVisible(false);
    }
}
