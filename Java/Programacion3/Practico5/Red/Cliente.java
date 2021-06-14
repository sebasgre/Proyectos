package Practico5.Red;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cliente extends JFrame {
    private JPanel menu = new JPanel();
    private JTextField usuario = new JTextField();

    public Cliente() {
        this.setTitle("Cliente");
        this.setSize(400, 500);
        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void init() {
        menu.setLayout(null);
        menu.setBackground(new Color(159, 213, 209));
        add(menu);

        JLabel foto = new JLabel(new ImageIcon(
                "fondo.png"));
        foto.setBounds(0, 0, 490, 480);
        foto.setVisible(true);
        menu.add(foto, null);

        JLabel persona = new JLabel("Usuario:");
        persona.setForeground(Color.white);
        persona.setFont(new java.awt.Font("OnePlusSans", 0, 24));
        persona.setBounds(140, 180, 140, 50);
        foto.add(persona, null);

        usuario.setBounds(140, 230, 120, 25);
        usuario.setOpaque(false);
        usuario.setForeground(Color.white);
        foto.add(usuario, null);

        JButton next = new JButton("Aceptar");
        next.setOpaque(false);
        next.setBackground(new Color(0, 0, 0, 0));
        next.setContentAreaFilled(false);
        next.setBounds(140, 260, 120, 25);
        next.setForeground(Color.white);
        foto.add(next, null);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                conectar();
            }
        });

    }

    public void conectar() {
        try {
            String id = usuario.getText();

            Socket s = new Socket("localhost", 2089);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(id);
            String i = new DataInputStream(s.getInputStream()).readUTF();
            if (i.equals("Ya estas registrado")) {
                JOptionPane.showMessageDialog(this, "YA ESTA REGISTRADO\n");
            } else {
                Chat chat = new Chat(id, s);
                this.dispose();
                chat.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
