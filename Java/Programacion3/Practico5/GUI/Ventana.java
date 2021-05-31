package Practico5.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Practico5.Lista.Lista;
import Practico5.Vista.Dibujo;
import Practico5.Vista.iDibujo;

public class Ventana extends JFrame {
    private Lista<String> listaMensaje = new Lista<>();
    private iDibujo dibujar = new Dibujo(listaMensaje);
    private panelServidor panelServidor = new panelServidor(dibujar);
    private panelClientes panelClientes = new panelClientes(dibujar);

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
                
            }
        });

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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

}
