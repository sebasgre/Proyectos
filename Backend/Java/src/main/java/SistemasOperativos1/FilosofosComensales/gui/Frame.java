package SistemasOperativos1.FilosofosComensales.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private Panel1 panel1;
    private Panel2 panel2;
    private JButton boton;

    private JButton estadoFilosofo1;
    private JButton estadoFilosofo2;
    private JButton estadoFilosofo3;
    private JButton estadoFilosofo4;
    private JButton estadoFilosofo5;

    private JLabel porcentaje1;
    private JLabel porcentaje2;
    private JLabel porcentaje3;
    private JLabel porcentaje4;
    private JLabel porcentaje5;

    private JLabel filosofo1;
    private JLabel filosofo2;
    private JLabel filosofo3;
    private JLabel filosofo4;
    private JLabel filosofo5;

    private JScrollPane jScrollPane1;

    private JLabel labCom1;
    private JLabel labCom2;
    private JLabel labCom3;
    private JLabel labCom4;
    private JLabel labCom5;

    private JLabel labTen1;
    private JLabel labTen2;
    private JLabel labTen3;
    private JLabel labTen4;
    private JLabel labTen5;
    private JTextArea tAreaProceso;
    //private final static Logger logger = LogManager.getLogger();

    public Frame() {
        init1();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        estadoFilosofo1 = new JButton();
        estadoFilosofo2 = new JButton();
        estadoFilosofo3 = new JButton();
        estadoFilosofo4 = new JButton();
        estadoFilosofo5 = new JButton();
        porcentaje1 = new JLabel();
        porcentaje2 = new JLabel();
        porcentaje3 = new JLabel();
        porcentaje4 = new JLabel();
        porcentaje5 = new JLabel();
        labTen1 = new JLabel();
        labTen2 = new JLabel();
        labTen3 = new JLabel();
        labTen4 = new JLabel();
        labTen5 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tAreaProceso = new JTextArea();
        filosofo1 = new JLabel();
        filosofo2 = new JLabel();
        filosofo3 = new JLabel();
        filosofo4 = new JLabel();
        filosofo5 = new JLabel();
        labCom1 = new JLabel();
        labCom2 = new JLabel();
        labCom3 = new JLabel();
        labCom4 = new JLabel();
        labCom5 = new JLabel();
        panel2.setLayout(null);
    }

    private void cargarComponentes() {
        iniciarComponentes();
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Comenzar");
        item.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                iniciar();
            }
        });
        menu.add(item);
        bar.add(menu);
        this.setJMenuBar(bar);
        labTen1.setText("Ten1");
        labTen1.setBounds(320, 90, 100, 20);
        panel2.add(labTen1);

        labTen2.setText("Ten2");
        labTen2.setBounds(360, 230, 100, 20);
        panel2.add(labTen2);

        labTen3.setText("Ten3");
        labTen3.setBounds(200, 320, 100, 20);
        panel2.add(labTen3);

        labTen4.setText("Ten4");
        labTen4.setBounds(80, 230, 100, 20);
        panel2.add(labTen4);

        labTen5.setText("Ten5");
        labTen5.setBounds(100, 90, 100, 20);
        panel2.add(labTen5);

        estadoFilosofo1.setText("Filosofo1");
        estadoFilosofo1.setBounds(190, 50, 100, 20);
        porcentaje1.setText("0%");
        porcentaje1.setBounds(190, 30, 100, 20);
        panel2.add(estadoFilosofo1);
        panel2.add(porcentaje1);

        estadoFilosofo2.setText("Filosofo2");
        estadoFilosofo2.setBounds(370, 160, 100, 20);
        porcentaje2.setText("0%");
        porcentaje2.setBounds(370, 140, 100, 20);
        panel2.add(estadoFilosofo2);
        panel2.add(porcentaje2);

        estadoFilosofo3.setText("Filosofo3");
        estadoFilosofo3.setBounds(270, 330, 100, 20);
        porcentaje3.setText("0%");
        porcentaje3.setBounds(270, 310, 100, 20);
        panel2.add(estadoFilosofo3);
        panel2.add(porcentaje3);

        estadoFilosofo4.setText("Filosofo4");
        estadoFilosofo4.setBounds(70, 330, 100, 20);
        porcentaje4.setText("0%");
        porcentaje4.setBounds(60, 310, 100, 20);
        panel2.add(estadoFilosofo4);
        panel2.add(porcentaje4);

        estadoFilosofo5.setText("Filosofo5");
        estadoFilosofo5.setBounds(10, 160, 100, 20);
        porcentaje5.setText("0%");
        porcentaje5.setBounds(90, 140, 100, 20);
        panel2.add(estadoFilosofo5);
        panel2.add(porcentaje5);

        int x = 500;
        int y = 30;
        filosofo1.setText("Filosofo 01");
        filosofo1.setBounds(x, y, 100, 20);
        filosofo2.setText("Filosofo 02");
        filosofo2.setBounds(x + 100, y, 100, 20);
        filosofo3.setText("Filosofo 03");
        filosofo3.setBounds(x + 200, y, 100, 20);
        filosofo4.setText("Filosofo 04");
        filosofo4.setBounds(x + 300, y, 100, 20);
        filosofo5.setText("Filosofo 05");
        filosofo5.setBounds(x + 400, y, 100, 20);
        panel2.add(filosofo1);
        panel2.add(filosofo2);
        panel2.add(filosofo3);
        panel2.add(filosofo4);
        panel2.add(filosofo5);

        tAreaProceso.setEditable(false);
        jScrollPane1.setBounds(x, y + 50, 460, 250);
        jScrollPane1.setVerticalScrollBarPolicy(jScrollPane1.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(tAreaProceso);
        panel2.add(jScrollPane1);

        y += 20;
        x += 25;
        labCom1.setText("0");
        labCom1.setBounds(x, y, 50, 20);
        labCom2.setText("0");
        labCom2.setBounds(x + 100, y, 100, 20);
        labCom3.setText("0");
        labCom3.setBounds(x + 200, y, 100, 20);
        labCom4.setText("0");
        labCom4.setBounds(x + 300, y, 100, 20);
        labCom5.setText("0");
        labCom5.setBounds(x + 400, y, 100, 20);
        panel2.add(labCom1);
        panel2.add(labCom2);
        panel2.add(labCom3);
        panel2.add(labCom4);
        panel2.add(labCom5);
        this.pack();
    }

    public void iniciar() {
        JButton filosofo[];
        filosofo = new JButton[5];
        filosofo[0] = estadoFilosofo1;
        filosofo[1] = estadoFilosofo2;
        filosofo[2] = estadoFilosofo3;
        filosofo[3] = estadoFilosofo4;
        filosofo[4] = estadoFilosofo5;

        JLabel porcentaje[];
        porcentaje = new JLabel[5];
        porcentaje[0] = porcentaje1;
        porcentaje[1] = porcentaje2;
        porcentaje[2] = porcentaje3;
        porcentaje[3] = porcentaje4;
        porcentaje[4] = porcentaje5;

        Filosofo com;

        JLabel tenedor[];
        tenedor = new JLabel[5];
        tenedor[0] = labTen1;
        tenedor[1] = labTen2;
        tenedor[2] = labTen3;
        tenedor[3] = labTen4;
        tenedor[4] = labTen5;

        JLabel resultado[];
        resultado = new JLabel[5];
        resultado[0] = labCom1;
        resultado[1] = labCom2;
        resultado[2] = labCom3;
        resultado[3] = labCom4;
        resultado[4] = labCom5;

        int i = 0, izq, der = 0;

        int vector[] = new int[5];
        vector[i] = (int) (Math.random() * 5);
        for (i = 1; i < 5; i++) {
            vector[i] = (int) (Math.random() * 5);
            for (int j = 0; j < i; j++) {
                if (vector[i] == vector[j]) {
                    i--;
                }
            }
        }

        for (int k = 0; k < 5; k++) {
            izq = vector[k] - 1;

            if (izq < 0) {
                izq = 4;
            }
            der = vector[k];
            //logger.info("Filosofo random ingresado " + vector[k]);
            com = new Filosofo(vector[k], tenedor[izq], tenedor[der], filosofo[vector[k]], porcentaje[vector[k]],
                    resultado[vector[k]], tAreaProceso);
        }
    }

    public void init1() {
        panel1 = new Panel1();
        cargarBoton();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel1, BorderLayout.CENTER);
        this.pack();
    }

    public void init2() {
        panel2 = new Panel2();
        cargarComponentes();
        this.remove(panel1);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void cargarBoton() {
        boton = new JButton();
        boton.setBounds(540, 340, 60, 60);
        ImageIcon image1 = new ImageIcon(
                getClass().getClassLoader().getResource("Java/SistemasOperativos1/Imagenes/flecha.png"));
        boton.setFocusPainted(false);
        boton.setBorder(null);
        boton.setBackground(Color.white);
        boton.setIcon(new ImageIcon(
                image1.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), image1.getImageLoadStatus())));
        boton.setOpaque(true);
        panel1.add(boton);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init2();
            }
        });
    }
}
