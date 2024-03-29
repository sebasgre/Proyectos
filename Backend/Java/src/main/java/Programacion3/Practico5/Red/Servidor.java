package Programacion3.Practico5.Red;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Servidor extends JFrame {
    private JLabel chat = new JLabel();
    private JLabel participantes = new JLabel();
    private JTextArea jPanelChat = new JTextArea();
    private JTextArea jPanelPaticipa = new JTextArea();
    private ServerSocket ss;
    private HashMap clienteColl = new HashMap();

    public Servidor() {
        this.setTitle("Servidor");
        this.setSize(545, 520);
        this.setLayout(null);
        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            ss = new ServerSocket(2089);
            new ClientAccept().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        jPanelPaticipa.setBackground(new java.awt.Color(0, 0, 0));
        jPanelPaticipa.setBounds(370, 50, 150, 400);
        jPanelPaticipa.setEditable(false);
        jPanelPaticipa.setForeground(Color.white);

        participantes.setFont(new java.awt.Font("OnePlusSans", 0, 24));
        participantes.setText("Participantes");
        participantes.setBounds(380, -20, 150, 100);

        jPanelChat.setBackground(new java.awt.Color(0, 0, 0));
        jPanelChat.setBounds(10, 50, 350, 400);
        jPanelChat.setEditable(false);
        jPanelChat.setForeground(Color.white);

        chat.setFont(new java.awt.Font("OnePlusSans", 0, 24));
        chat.setText("Chat");
        chat.setBounds(170, -20, 100, 100);

        add(jPanelChat, null);
        add(jPanelPaticipa, null);
        add(participantes, null);
        add(chat, null);

    }

    class ClientAccept extends Thread {

        public void run() {
            while (true) {
                try {
                    Socket s = ss.accept();
                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    if (clienteColl.containsKey(i)) {
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                        dout.writeUTF("Ya estas registrado");

                    } else {
                        clienteColl.put(i, s);
                        jPanelPaticipa.append(i + " Se unio\n");
                        DataOutputStream dout = new DataOutputStream((s.getOutputStream()));
                        dout.writeUTF("");
                        new MsgRead(s, i).start();
                        new PrepareClientList().start();
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    class MsgRead extends Thread {
        Socket s;
        String ID;

        MsgRead(Socket s, String ID) {
            this.s = s;
            this.ID = ID;
        }

        public void run() {
            while (!clienteColl.isEmpty()) {
                try {
                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    Set k = clienteColl.keySet();
                    Iterator itr = k.iterator();
                    while (itr.hasNext()) {
                        String key = (String) itr.next();
                        if (!key.equalsIgnoreCase(ID)) {
                            try {
                                new DataOutputStream(((Socket) clienteColl.get(key)).getOutputStream()).writeUTF("< " + ID + " A todos dice >" + i);
                            } catch (Exception e) {
                            }
                        }
                    }
                    jPanelChat.append("< " + ID + " A todos dice >" + i + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class PrepareClientList extends Thread {
        public void run() {
            try {
                String ids = "";
                Set k = clienteColl.keySet();
                Iterator itr = k.iterator();
                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    ids += key + ",";
                }
                if (ids.length() != 0) {
                    ids = ids.substring(0, ids.length() - 1);
                }

                itr = k.iterator();

                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    try {
                        new DataOutputStream(((Socket) clienteColl.get(key)).getOutputStream()).writeUTF(":;.,/=" + ids);
                    } catch (Exception e) {
                        clienteColl.remove(key);
                        jPanelPaticipa.append(key + " :Salio" + "\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    
}
