package Programacion3.practico7y8.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Programacion3.practico7y8.modelo.ArbolAritmetico;

public class Calculadora implements ActionListener, PropertyChangeListener {

    private PanelArbol panel;
    private ArbolAritmetico modelo;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;

    private JButton btnSuma;
    private JButton btnResta;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JButton btnDecimal;
    private JButton btnIgualdad;
    private JButton btnPotencia;
    private JButton btnRaiz;
    private JButton btnAC;
    private JButton btnDEL;
    private JButton btnParentesisAbierto;
    private JButton btnParentesisCerrado;

    private JLabel lbVisual;
    private JLabel lbPantalla;
    private JLabel lbPosiciones;

    private JScrollPane scroll;
    private String pantalla = "";


    private void iniciarComponentes() {
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnParentesisAbierto = new JButton("(");
        btnParentesisCerrado = new JButton(")");
        btnSuma = new JButton();
        btnResta = new JButton();
        btnMultiplicacion = new JButton();
        btnDivision = new JButton();
        btnDecimal = new JButton(".");
        btnIgualdad = new JButton();
        btnPotencia = new JButton("^");
        btnRaiz = new JButton();
        btnAC = new JButton();
        btnDEL = new JButton();
        lbVisual = new JLabel();
        lbPantalla = new JLabel();
        lbPosiciones = new JLabel();
        scroll = new JScrollPane();
    }
    public Calculadora(PanelArbol panel, ArbolAritmetico modelo) {
        this.panel = panel;
        this.modelo = modelo;
        iniciarComponentes();
        cargarCalculadora();
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    private void cargarCalculadora() {
        lbVisual.setOpaque(true);
        lbPantalla.setOpaque(true);
        lbPosiciones.setOpaque(true);
        lbVisual.setBounds(140, 20, 300, 70);
        scroll.setBounds(140, 90, 300, 50);
        lbPosiciones.setBounds(140, 140, 300, 380);
        lbVisual.setBackground(Color.WHITE);
        lbPantalla.setBackground(Color.WHITE);
        lbPantalla.setHorizontalAlignment(lbVisual.RIGHT);
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_ALWAYS);
        Font fuente1 = new Font("OnePlusSans", Font.BOLD, 32);
        Font fuente2 = new Font("OnePlusSans", Font.BOLD, 24);
        lbVisual.setText(" INGRESE EXPRESIÓN:");
        lbVisual.setForeground(Color.RED);
        lbPantalla.setForeground(Color.BLACK);
        lbPantalla.setFont(fuente1);
        lbVisual.setFont(fuente2);
        scroll.setViewportView(lbPantalla);
        btnAC.setBounds(10, 0, 50, 40);
        btnAC.setText("AC");
        btnAC.setForeground(Color.BLACK);
        btnAC.setBackground(Color.WHITE);
        btnAC.setFocusPainted(false);
        btnAC.setBorder(null);
        btnAC.setFont(fuente2);
        btnDEL.setBounds(80, 0, 50, 40);
        btnDEL.setText("DEL");
        btnDEL.setForeground(Color.BLACK);
        btnDEL.setBackground(Color.WHITE);
        btnDEL.setFocusPainted(false);
        btnDEL.setBorder(null);
        btnDEL.setFont(fuente2);
        btnRaiz.setBounds(220, 0, 50, 40);
        ImageIcon image1 = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/raiz.png"));
        btnRaiz.setBorder(null);
        btnRaiz.setBackground(Color.WHITE);
        btnRaiz.setIcon(new ImageIcon(image1.getImage().getScaledInstance(btnRaiz.getWidth(), btnRaiz.getHeight(), image1.getImageLoadStatus())));
        btnDivision.setBounds(220, 100, 50, 40);
        ImageIcon image2 = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/division.png"));
        btnDivision.setBorder(null);
        btnDivision.setBackground(Color.WHITE);
        btnDivision.setIcon(new ImageIcon(image2.getImage().getScaledInstance(btnDivision.getWidth(), btnDivision.getHeight(), image2.getImageLoadStatus())));
        btn7.setBounds(10, 50, 50, 40);
        btn7.setForeground(Color.BLACK);
        btn7.setBackground(Color.WHITE);
        btn7.setFocusPainted(false);
        btn7.setBorder(null);
        btn7.setFont(fuente2);
        btn8.setBounds(80, 50, 50, 40);
        btn8.setForeground(Color.BLACK);
        btn8.setBackground(Color.WHITE);
        btn8.setFocusPainted(false);
        btn8.setBorder(null);
        btn8.setFont(fuente2);
        btn9.setBounds(150, 50, 50, 40);
        btn9.setForeground(Color.BLACK);
        btn9.setBackground(Color.WHITE);
        btn9.setFocusPainted(false);
        btn9.setBorder(null);
        btn9.setFont(fuente2);
        btnMultiplicacion.setBounds(220, 150, 50, 40);
        ImageIcon image3 = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/multiplicacion.png"));
        btnMultiplicacion.setBorder(null);
        btnMultiplicacion.setBackground(Color.BLACK);
        btnMultiplicacion.setIcon(new ImageIcon(image3.getImage().getScaledInstance(btnMultiplicacion.getWidth(), btnMultiplicacion.getHeight(), image3.getImageLoadStatus())));
        btn4.setBounds(10, 100, 50, 40);
        btn4.setForeground(Color.BLACK);
        btn4.setBackground(Color.WHITE);
        btn4.setFocusPainted(false);
        btn4.setBorder(null);
        btn4.setFont(fuente2);
        btn5.setBounds(80, 100, 50, 40);
        btn5.setForeground(Color.BLACK);
        btn5.setBackground(Color.WHITE);
        btn5.setFocusPainted(false);
        btn5.setBorder(null);
        btn5.setFont(fuente2);
        btn6.setBounds(150, 100, 50, 40);
        btn6.setForeground(Color.BLACK);
        btn6.setBackground(Color.WHITE);
        btn6.setFocusPainted(false);
        btn6.setBorder(null);
        btn6.setFont(fuente2);
        btnResta.setBounds(220, 200, 50, 40);
        ImageIcon image4 = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/resta.png"));
        btnResta.setBorder(null);
        btnResta.setBackground(Color.WHITE);
        btnResta.setIcon(new ImageIcon(image4.getImage().getScaledInstance(btnResta.getWidth(), btnResta.getHeight(), image4.getImageLoadStatus())));
        btn1.setBounds(10, 150, 50, 40);
        btn1.setForeground(Color.BLACK);
        btn1.setBackground(Color.WHITE);
        btn1.setFocusPainted(false);
        btn1.setBorder(null);
        btn1.setFont(fuente2);
        btn2.setBounds(80, 150, 50, 40);
        btn2.setForeground(Color.BLACK);
        btn2.setBackground(Color.WHITE);
        btn2.setFocusPainted(false);
        btn2.setBorder(null);
        btn2.setFont(fuente2);
        btn3.setBounds(150, 150, 50, 40);
        btn3.setForeground(Color.BLACK);
        btn3.setBackground(Color.WHITE);
        btn3.setFocusPainted(false);
        btn3.setBorder(null);
        btn3.setFont(fuente2);
        btnSuma.setBounds(220, 250, 50, 40);
        ImageIcon image5 = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/suma.png"));
        btnSuma.setBorder(null);
        btnSuma.setBackground(Color.WHITE);
        btnSuma.setIcon(new ImageIcon(image5.getImage().getScaledInstance(50, 40, image5.getImageLoadStatus())));
        btnPotencia.setBounds(220, 50, 50, 40);
        btnPotencia.setForeground(Color.WHITE);
        btnPotencia.setBackground(Color.BLACK);
        btnPotencia.setFocusPainted(false);
        btnPotencia.setBorder(null);
        btnPotencia.setFont(fuente2);
        btn0.setBounds(10, 200, 120, 40);
        btn0.setForeground(Color.BLACK);
        btn0.setBackground(Color.WHITE);
        btn0.setFocusPainted(false);
        btn0.setBorder(null);
        btn0.setFont(fuente2);
        btnParentesisAbierto.setBounds(150, 200, 50, 40);
        btnParentesisAbierto.setForeground(Color.BLACK);
        btnParentesisAbierto.setBackground(Color.WHITE);
        btnParentesisAbierto.setFocusPainted(false);
        btnParentesisAbierto.setBorder(null);
        btnParentesisAbierto.setFont(fuente2);
        btnDecimal.setBounds(150, 0, 50, 40);
        btnDecimal.setForeground(Color.BLACK);
        btnDecimal.setBackground(Color.WHITE);
        btnDecimal.setFocusPainted(false);
        btnDecimal.setBorder(null);
        btnDecimal.setFont(fuente2);
        btnIgualdad.setBounds(10, 250, 120, 40);
        ImageIcon image6 = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/igual.png"));
        btnIgualdad.setBorder(null);
        btnIgualdad.setBackground(Color.WHITE);
        btnIgualdad.setIcon(new ImageIcon(image6.getImage().getScaledInstance(btnIgualdad.getWidth(), btnIgualdad.getHeight(), image6.getImageLoadStatus())));
        btnParentesisCerrado.setBounds(150, 250, 50, 40);
        btnParentesisCerrado.setForeground(Color.BLACK);
        btnParentesisCerrado.setBackground(Color.WHITE);
        btnParentesisCerrado.setFocusPainted(false);
        btnParentesisCerrado.setBorder(null);
        btnParentesisCerrado.setFont(fuente2);
        lbPosiciones.add(btnAC);
        lbPosiciones.add(btnDEL);
        lbPosiciones.add(btnRaiz);
        lbPosiciones.add(btnPotencia);
        lbPosiciones.add(btn7);
        lbPosiciones.add(btn8);
        lbPosiciones.add(btn9);
        lbPosiciones.add(btnDivision);
        lbPosiciones.add(btnMultiplicacion);
        lbPosiciones.add(btn4);
        lbPosiciones.add(btn5);
        lbPosiciones.add(btn6);
        lbPosiciones.add(btnResta);
        lbPosiciones.add(btn1);
        lbPosiciones.add(btn2);
        lbPosiciones.add(btn3);
        lbPosiciones.add(btnSuma);
        lbPosiciones.add(btn0);
        lbPosiciones.add(btnDecimal);
        lbPosiciones.add(btnIgualdad);
        lbPosiciones.add(btnParentesisAbierto);
        lbPosiciones.add(btnParentesisCerrado);
        panel.add(lbPosiciones);
        panel.add(scroll);
        panel.add(lbVisual);
        panel.setVisible(true);
        cargarListeners();
    }

    public void cargarListeners() {
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnRaiz.addActionListener(this);
        btnAC.addActionListener(this);
        btnDecimal.addActionListener(this);
        btnDEL.addActionListener(this);
        btnDivision.addActionListener(this);
        btnIgualdad.addActionListener(this);
        btnMultiplicacion.addActionListener(this);
        btnPotencia.addActionListener(this);
        btnSuma.addActionListener(this);
        btnResta.addActionListener(this);
        btnParentesisAbierto.addActionListener(this);
        btnParentesisCerrado.addActionListener(this);
    }

    private boolean vacio = true;

    public boolean signosRepetidos(String expresion) {
        if (expresion.equals("") && vacio) {
            vacio = false;
            return false;
        }
        String ultimo = expresion.substring(expresion.length() - 1);
        if (ultimo.equals("+") || ultimo.equals("-") || ultimo.equals("*") || ultimo.equals("/") || ultimo.equals("√") || ultimo.equals("^") || ultimo.equals(".")) {
            return true;
        } else {
            return false;
        }
    }
    private boolean punto = false;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(btn0))
            pantalla += "0";


        if (e.getSource().equals(btn1))
            pantalla += "1";


        if (e.getSource().equals(btn2))
            pantalla += "2";


        if (e.getSource().equals(btn3))
            pantalla += "3";


        if (e.getSource().equals(btn4))
            pantalla += "4";


        if (e.getSource().equals(btn5))
            pantalla += "5";


        if (e.getSource().equals(btn6))
            pantalla += "6";


        if (e.getSource().equals(btn7))
            pantalla += "7";


        if (e.getSource().equals(btn8))
            pantalla += "8";


        if (e.getSource().equals(btn9))
            pantalla += "9";

        if (e.getSource().equals(btnParentesisAbierto))
            pantalla += "(";

        if (e.getSource().equals(btnParentesisCerrado))
            pantalla += ")";


        if (e.getSource().equals(btnRaiz)) {
            if (!signosRepetidos(pantalla)) {
                pantalla += "√";
                punto = false;
            }
        }

        if (e.getSource().equals(btnSuma)) {
            if (!signosRepetidos(pantalla)) {
                pantalla += "+";
                punto = false;
            }
        }

        if (e.getSource().equals(btnResta)) {
            if (!signosRepetidos(pantalla)) {
                pantalla += "-";
                punto = false;
            }
        }

        if (e.getSource().equals(btnMultiplicacion)) {
            if (!signosRepetidos(pantalla)) {
                pantalla += "*";
                punto = false;
            }
        }

        if (e.getSource().equals(btnDivision)) {
            if (!signosRepetidos(pantalla)) {
                pantalla += "/";
                punto = false;
            }
        }
        if (e.getSource().equals(btnDecimal)) {
            if(!punto) {
                if (!signosRepetidos(pantalla)) {
                    pantalla += ".";
                    punto = true;
                }
            }
        }

        if (e.getSource().equals(btnPotencia)) {
            if (!signosRepetidos(pantalla)) {
                pantalla += "^";
                punto = false;
            }
        }


        if (e.getSource().equals(btnDEL)) {
            if (pantalla.length() > 0){
                if(pantalla.substring(pantalla.length() - 1).equals("."))
                    punto = false;
                pantalla = pantalla.substring(0, pantalla.length() - 1);
            }
        }

        if (e.getSource().equals(btnAC)) {
            pantalla = "";
            vacio = true;
            if (modelo != null) {
                modelo.setRaiz(null);
                panel.setModelo(modelo);
                modelo.cambioOk();
            }
            punto = false;
        }

        if (e.getSource().equals(btnIgualdad)) {
            try {
                if(pantalla.equals("")) {
                    return;
                }
                modelo = new ArbolAritmetico(pantalla);
                modelo.addObserver(panel);
                panel.setModelo(modelo);
                modelo.cambioOk();
                System.out.println(("Nueva expresion: " + pantalla));
                pantalla = String.valueOf(modelo.evaluar());
                punto = false;
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane optionPane = new JOptionPane("Syntax error", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Warning");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                pantalla = "";
                lbPantalla.setText(pantalla);
                punto = false;
            }
        }
        lbPantalla.setText(pantalla);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        pantalla = String.valueOf(panel.getModelo().evaluar());
        lbPantalla.setText(pantalla);
    }
}
