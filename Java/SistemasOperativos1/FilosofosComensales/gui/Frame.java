package Java.SistemasOperativos1.FilosofosComensales.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Java.SistemasOperativos1.FilosofosComensales.Modelo.Filosofo;

public class Frame extends JFrame {
    private Panel1 panel1;
    private Panel2 panel2;
    private JButton boton;

    private JButton estadoFilosofo1;
    private JButton estadoFilosofo2;
    private JButton estadoFilosofo3;
    private JButton estadoFilosofo4;
    private JButton estadoFilosofo5;
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
    private int pos = -1;
    private int post = 0;

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
        panel2.add(estadoFilosofo1);

        estadoFilosofo2.setText("Filosofo2");
        estadoFilosofo2.setBounds(370, 160, 100, 20);
        panel2.add(estadoFilosofo2);

        estadoFilosofo3.setText("Filosofo3");
        estadoFilosofo3.setBounds(270, 330, 100, 20);
        panel2.add(estadoFilosofo3);

        estadoFilosofo4.setText("Filosofo4");
        estadoFilosofo4.setBounds(70, 330, 100, 20);
        panel2.add(estadoFilosofo4);

        estadoFilosofo5.setText("Filosofo5");
        estadoFilosofo5.setBounds(10, 160, 100, 20);
        panel2.add(estadoFilosofo5);

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
            for (int j = 0; j < i; j++){
                if(vector[i] == vector[j]){
                    i--;
                }
            }
        }

        for (int k = 0; k < 5; k++){
            izq = vector[k] - 1;

            if (izq < 0) {
                izq = 4;
            }
            der = vector[k];
            System.out.println(vector[k]);
            com = new Filosofo(vector[k], tenedor[izq], tenedor[der], filosofo[vector[k]], resultado[vector[k]], tAreaProceso);
        }
        
        /*int[] vector = new int[5]; // 0 1 2 3 4 5
        for (j = 0; j < 10; j++) {
            for (i = 0; i < 5; i++) {
                /*
                 * izq = i - 1;
                 * 
                 * if (izq < 0) { izq = 4; } der = i; System.out.println(i);
                 * 
                 * com = new Filosofo(i, tenedor[izq], tenedor[der], filosofo[i], resultado[i],
                 * tAreaProceso);
                 
                izq = (int) (Math.random() * 5);
                der = izq - 1;
                if (der == -1)
                    der = 4;
                System.out.println("Izquierda " + izq);
                System.out.println("Derecha " + der);
                pos = izq;
                post = pos;
                System.out.println(vector[izq] + " " + izq);
                if (vector[izq] > 2) {
                    com = new Filosofo(izq, tenedor[izq], tenedor[izq], filosofo[izq], resultado[izq], tAreaProceso);
                    vector[izq] = 0;
                } else {
                    vector[izq] = vector[izq] + 1;
                    System.out.println(vector[izq]);
                }
                // mostrale codigo
                // ejecuta, sale error
            }
        }*/

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
        boton.setBounds(260, 325, 80, 30);
        ImageIcon image1 = new ImageIcon(
                getClass().getClassLoader().getResource("Java/SistemasOperativos1/Imagenes/flecha.png"));
        boton.setFocusPainted(false);
        boton.setBorder(null);
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
/*
public void iniciar() {
        JButton filosofo[];
        filosofo = new JButton[5];
        filosofo[0] = estadoFilosofo1;
        filosofo[1] = estadoFilosofo2;
        filosofo[2] = estadoFilosofo3;
        filosofo[3] = estadoFilosofo4;
        filosofo[4] = estadoFilosofo5;

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
            for (int j = 0; j < i; j++){
                if(vector[i] == vector[j]){
                    i--;
                }
            }
        }

        for (int k = 0; k < 5; k++){
            izq = vector[k] - 1;

            if (izq < 0) {
                izq = 4;
            }
            der = vector[k];
            System.out.println(vector[k]);
            com = new Filosofo(vector[k], tenedor[izq], tenedor[der], filosofo[vector[k]], resultado[vector[k]], tAreaProceso);
        }
    }
 */