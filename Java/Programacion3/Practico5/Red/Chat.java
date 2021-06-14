package Practico5.Red;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chat extends JFrame {
    private JPanel panel = new JPanel();
    private final static Logger logger = LogManager.getLogger();
    private JTextField usuario = new JTextField();
    private JLabel foto = new JLabel(new ImageIcon(
            "WhatsApp-Wallpaper-30.jpg"));
    private JTextArea txt_mensajes = new JTextArea();
    
    private String iD;
    private DataInputStream din;
    private DataOutputStream dout;
    private DefaultListModel dlm;

    public Chat(String a, Socket s) {
        iD = a;
        this.setTitle("Chat " + iD);
        this.setSize(400, 520);
        init();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            dlm = new DefaultListModel();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            new Read().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        panel.setLayout(null);
        add(panel);

        foto.setBounds(0, 0, 490, 490);
        foto.setVisible(true);
        panel.add(foto, null);
    
        txt_mensajes.setBounds(0, 0, 490, 400);
        txt_mensajes.setEditable(false);
        txt_mensajes.setOpaque(false);
        txt_mensajes.setForeground(Color.white);
        foto.add(txt_mensajes, null);

        usuario.setBounds(50, 450, 270, 30);
        usuario.setForeground(Color.white);
        usuario.setBackground(new Color(159, 213, 209));
        foto.add(usuario, null);

        JButton plus = new JButton("+");
        plus.setBounds(0, 451, 50, 30);
        plus.setFont(new java.awt.Font("OnePlusSans", 0, 24));
        plus.setForeground(Color.WHITE);
        plus.setBackground(new Color(159, 213, 209));
        plus.setBorderPainted(false);
        foto.add(plus, null);

        JButton envio = new JButton("ENV");
        envio.setBounds(320, 450, 100, 30);
        envio.setFont(new java.awt.Font("OnePlusSans", 0, 24));
        envio.setForeground(Color.black);
        envio.setBackground(new Color(159, 213, 209));
        envio.setBorderPainted(false);
        envio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                logger.debug("envia");
                try {
                    String m = usuario.getText(), mm = m;
                    dout.writeUTF(m);
                    usuario.setText("");
                    int esp = (100 - mm.length() * 2);
                    String espacio = "";
                    for (int a = 0; a < esp; a++) {
                        espacio += " ";
                    }
                    txt_mensajes.append(espacio + "<Tu a todos> " + mm + "\n");

                } catch (Exception e) {
                }
            }
        });
        foto.add(envio, null);
    }

    class Read extends Thread {
        public void run() {
            while (true) {
                try {
                    String m = din.readUTF();
                    if (m.contains(":;.,/=")) {
                        m = m.substring(6);
                        dlm.clear();
                        StringTokenizer st = new StringTokenizer(m, ",");
                        while (st.hasMoreTokens()) {
                            String u = st.nextToken();
                            if (!iD.equals(u)) {
                                dlm.addElement(u);
                            }
                        }
                    } else {
                        txt_mensajes.append("" + m + "\n");

                    }
                } catch (Exception e) {
                    break;
                }
            }

        }
    }
}
