package Practico5.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Practico5.Lista.Lista;
import Practico5.Red.Enviar;
import Practico5.Red.Recibir;
import Practico5.Modelo.Mensaje;

public class ventanaUsuario extends JFrame {
    private panelLogin panel = new panelLogin();
    // private panelClientes panel = new panelClientes();
    private Enviar conexion;
    private JLabel lbNombre = new JLabel("Nombre:");
    private JLabel lbHost = new JLabel("Host:");
    private JLabel lbPuerto = new JLabel("Puerto:");
    private JTextField campoNombre = new JTextField();
    private JTextField campoHost = new JTextField();
    private JTextField campoPuerto = new JTextField();
    private boolean control = false;

    public ventanaUsuario() {
        init();
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(JTextField campoNombre) {
        this.campoNombre = campoNombre;
    }

    public void init() {
        panel.setLayout(null);
        Font fuente1 = new Font("OnePlusSans", Font.BOLD, 24);
        Font fuente2 = new Font("OnePlusSans", Font.BOLD, 32);
        JLabel lbInicio = new JLabel("Inicio de sesión");
        lbInicio.setFont(fuente2);
        lbNombre.setFont(fuente1);
        lbHost.setFont(fuente1);
        lbPuerto.setFont(fuente1);
        lbInicio.setForeground(Color.WHITE);
        lbNombre.setForeground(Color.WHITE);
        lbHost.setForeground(Color.WHITE);
        lbPuerto.setForeground(Color.WHITE);
        lbInicio.setBounds(120, 0, 250, 100);
        lbNombre.setBounds(50, 80, 100, 80);
        lbHost.setBounds(50, 160, 100, 80);
        lbPuerto.setBounds(50, 240, 100, 80);
        campoNombre.setBounds(200, 100, 200, 40);
        campoHost.setBounds(200, 180, 200, 40);
        campoPuerto.setBounds(200, 260, 200, 40);
        JButton btnContinuar = new JButton();
        btnContinuar.setBounds(400, 350, 50, 50);
        ImageIcon image = new ImageIcon(
                "C:\\Users\\Sebastian\\OneDrive\\Documentos\\Visual Studio Code\\Proyectos\\Java\\Programacion3\\practico5\\Fotos\\continuar.png");
        btnContinuar.setIcon(new ImageIcon(image.getImage().getScaledInstance(btnContinuar.getWidth(),
                btnContinuar.getHeight(), image.getImageLoadStatus())));
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(null);
        panel.add(lbInicio);
        panel.add(lbNombre);
        panel.add(lbHost);
        panel.add(lbPuerto);
        panel.add(campoNombre);
        panel.add(campoHost);
        panel.add(campoPuerto);
        panel.add(btnContinuar);

        btnContinuar.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectarse();
                if (control == true) {
                    cambioPanel();
                    Ventana ventana = new Ventana();
                    ventana.initClientes();
                    ventana.setVisible(true);
                }
            }
        });
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void conectarse() {
        control = true;
        String ip = campoHost.getText();
        int puerto = Integer.parseInt(campoPuerto.getText());
        int leerPuerto = leerPuerto(puerto);
        if (leerPuerto == 0) {
            JOptionPane.showMessageDialog(this, "El puerto debe ser un entero mas de 1024");
            control = false;
            return;
        }

        String direccion = leerIP(ip);
        if (direccion.equals("ERROR")) {
            JOptionPane.showMessageDialog(this, "La ip deben ser 4 numeros enteros menores a 255");
            control = false;
            return;
        }

        try {
            conexion = new Enviar(ip, leerPuerto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo conectar al servidor con la ip " + ip + " con el puerto " + leerPuerto);
            control = false;
            return;
        }

        Recibir recibir;
        try {
            recibir = new Recibir(conexion.getSck());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Hubo un error al crear el objeto para recibir, trate de nuevo");
            control = false;
            return;
        }

        try {
            conexion = new Enviar(recibir.getClt());
            // panelImagen.setEnviar(conexion);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Hubo un error al crear el objeto para enviar, trate de nuevo");
            control = false;
            return;
        }

        Thread recibiendo = new Thread(recibir);
        recibiendo.start();
        añadirObservador();

    }

    private String leerIP(String ip) {
        String[] numeros = ip.split("\\.");
        StringBuilder respuesta = new StringBuilder();
        if (numeros.length != 4)
            return "ERROR";
        for (String unNumero : numeros) {
            int n = Integer.parseInt(unNumero);
            try {
                if (n < 0 || n > 255)
                    return "ERROR";
            } catch (Exception e) {
                return "ERROR";
            }

            respuesta.append("." + n);
        }
        return respuesta.substring(1);
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
