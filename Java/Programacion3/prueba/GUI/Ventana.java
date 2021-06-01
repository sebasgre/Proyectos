package prueba.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import prueba.Lista.Lista;
import prueba.Modelo.Mensaje;
import prueba.Red.Enviar;
import prueba.Red.Recibir;
import prueba.Vista.Dibujo;
import prueba.Vista.iDibujo;

public class Ventana extends JFrame {
    private Lista<Mensaje> lista = new Lista<>();
    private iDibujo dibujar = new Dibujo(lista);
    private panelServidor panelServidor = new panelServidor(dibujar);
    private panelClientes panelClientes = new panelClientes(dibujar);
    private Enviar conexion;
    private String archivo;
    private BufferedImage imagen;
    private JFileChooser chooser = new JFileChooser();

    public void initServidor() {
        JScrollPane scrollPane1 = new JScrollPane();
        JScrollPane scrollPane2 = new JScrollPane();
        JTextArea enLinea = new JTextArea();
        JTextArea conversaciones = new JTextArea();
        Font font = new Font("OnePlusSans", Font.BOLD, 14);
        JLabel lbConversaciones = new JLabel("Conversaciones");
        JLabel lbParticipantes = new JLabel("Participantes");
        lbConversaciones.setFont(font);
        lbParticipantes.setFont(font);
        scrollPane1.setBounds(0, 30, 400, 400);
        scrollPane2.setBounds(400, 30, 200, 400);
        lbConversaciones.setBounds(160, 0, 120, 30);
        lbParticipantes.setBounds(460, 0, 100, 30);
        panelServidor.setLayout(null);
        scrollPane1.setViewportView(conversaciones);
        scrollPane2.setViewportView(enLinea);
        scrollPane2.setVerticalScrollBarPolicy(scrollPane2.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setVerticalScrollBarPolicy(scrollPane1.VERTICAL_SCROLLBAR_ALWAYS);
        panelServidor.add(scrollPane1);
        panelServidor.add(scrollPane2);
        panelServidor.add(lbConversaciones);
        panelServidor.add(lbParticipantes);
        esperarConexion();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelServidor);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initClientes() {
        JTextArea chats = new JTextArea();
        JScrollPane scrollPane1 = new JScrollPane();
        JScrollPane scrollPane2 = new JScrollPane();
        JButton btnMas = new JButton();
        JButton btnEnviar = new JButton();
        JTextArea campoTexto = new JTextArea();
        scrollPane1.setBounds(0, 0, 300, 250);
        scrollPane2.setBounds(50, 250, 200, 50);
        btnMas.setBounds(0, 250, 50, 50);
        btnEnviar.setBounds(250, 250, 50, 50);
        panelClientes.setLayout(null);
        scrollPane1.setViewportView(chats);
        scrollPane1.setVerticalScrollBarPolicy(scrollPane1.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setViewportView(campoTexto);
        scrollPane2.setVerticalScrollBarPolicy(scrollPane2.VERTICAL_SCROLLBAR_ALWAYS);
        ImageIcon imagen1 = new ImageIcon(
                "C:\\Users\\Sebastian\\OneDrive\\Documentos\\Visual Studio Code\\Proyectos\\Java\\Programacion3\\practico5\\Fotos\\agregar.jpg");
        btnMas.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(btnMas.getWidth(), btnMas.getHeight(),
                imagen1.getImageLoadStatus())));
        ImageIcon imagen2 = new ImageIcon(
                "C:\\Users\\Sebastian\\OneDrive\\Documentos\\Visual Studio Code\\Proyectos\\Java\\Programacion3\\practico5\\Fotos\\enviar.png");
        btnEnviar.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(btnEnviar.getWidth(),
                btnEnviar.getHeight(), imagen2.getImageLoadStatus())));

        btnMas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarImagen();
                campoTexto.setText(conexion.getMensaje());
            }
        });

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime myObj = LocalDateTime.now();// logger
                conexion.setDateTime(myObj);
                conexion.setMensaje(campoTexto.getText());
                campoTexto.setText("");
            }
        });

        panelClientes.add(btnMas);
        panelClientes.add(btnEnviar);
        panelClientes.add(scrollPane1);
        panelClientes.add(scrollPane2);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelClientes);
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

    public void enviarImagen() {
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tipo de archivo imagen", "jpg", "png");
            chooser.setDialogTitle("Escoge una imagen...");
            chooser.setFileFilter(filtro);
            int validarArchivo = chooser.showOpenDialog(null);
            if (validarArchivo == JFileChooser.APPROVE_OPTION) {
                imagen = ImageIO.read(chooser.getSelectedFile());
                archivo = chooser.getSelectedFile().getAbsolutePath();
                conexion.setMensaje(archivo);
                if (!(imagen.getWidth() == 300) && !(imagen.getHeight() == 300))
                    JOptionPane.showMessageDialog(null, "Debe tener un ancho de 300 y un alto de 300");
            }
        } catch (Exception e) {

        }
    }

    private void añadirObservador() {
        lista.addObserver(conexion);
    }

}
