package Practico4.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Practico4.Lista.ListaOrdenada;
import Practico4.Modelo.Persona;
import Practico4.Vista.DibujarPersona;
import Practico4.Vista.IDibujo;


public class FramePrincipal extends JFrame {
    private final ListaOrdenada<Persona> listaPersonas = new ListaOrdenada<>();
    private final IDibujo dibujo = new DibujarPersona(listaPersonas);
    private final Panel panel = new Panel(dibujo);
    private boolean control = false;
    private final static Logger logger = LogManager.getLogger();

    public FramePrincipal() {
        init();
        this.setTitle("Admin De Personas");
    }

    private void init() {
        JMenuBar bar = new JMenuBar();
        JMenu menu1 = new JMenu("Personas");
        JMenuItem item1 = new JMenuItem("Nueva Persona");
        JMenuItem item2 = new JMenuItem("Eliminar a todos");
        JMenuItem item3 = new JMenuItem("Salir");
        item2.setEnabled(false);

        item1.addActionListener(e -> {
            crearPersona();
            item2.setEnabled(true);
        });

        item2.addActionListener(e -> eliminarTodos());

        item3.addActionListener(e -> System.exit(0));

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        bar.add(menu1);
        panel.setBackground(Color.BLACK);
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void crearPersona() {
        JTextField nombreField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField alturaField = new JTextField();
        JTextField generoField = new JTextField();
        Object[] message = {
                "Nombre: ", nombreField,
                "Edad: ", edadField,
                "Altura: ", alturaField,
                "Genero: ", generoField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nueva persona", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                Pattern patron = Pattern.compile("[0-9]");
                Matcher matcher1 = patron.matcher(edadField.getText());
                Matcher matcher2 = patron.matcher(alturaField.getText());
                if (matcher1.find() && matcher2.find()) {
                    int edad = Integer.parseInt(edadField.getText());
                    int altura = Integer.parseInt(alturaField.getText());
                    String infoText = "";
                    if (edad < 1 & !generoField.getText().toLowerCase().equals("masculino") && !generoField.getText().toLowerCase().equals("femenino") & (altura < 1 | altura > 250)) {
                        infoText = "Los datos ingresados en edad, altura y genero no son validos";
                        control = true;
                    } else if (edad < 1) {
                        infoText = "Ha sobrepasado la edad minima";
                        control = true;
                    } else if (altura < 1) {
                        infoText = "Ha sobrepasado la altura minima";
                        control = true;
                    } else if (altura > 250) {
                        infoText = "Ha sobrepasado la altura maxima";
                        control = true;
                    } else if (!generoField.getText().toLowerCase().equals("masculino") && !generoField.getText().toLowerCase().equals("femenino")) {
                        infoText = "El genero debe ser: Masculino o Femenino";
                        control = true;
                    }
                    if (control) {
                        JOptionPane.showMessageDialog(panel, infoText);
                        control = false;
                    } else {
                        Persona p = new Persona(nombreField.getText(), edad, altura, generoField.getText());
                        listaPersonas.insertar(p);
                        listaPersonas.addObserver(panel);
                        listaPersonas.cambioOk();
                        logger.debug("Nombre: " + nombreField.getText() + " Edad: " + edad + " Altura: " + altura + " Genero: " + generoField.getText());
                    }
                } else {
                    String texto;
                    if (!matcher1.find() && !matcher2.find())
                        texto = "Solo puede ingresar numeros enteros para la edad y la altura";
                    else if (!matcher2.find())
                        texto = "Solo puede ingresar numeros enteros para la altura";
                    else
                        texto = "Solo puede ingresar numeros enteros para la edad";

                    JOptionPane.showMessageDialog(panel, texto);
                }
            } catch (Exception e) {
                logger.debug("Error: " + e);
            }
        }

    }

    public void eliminarTodos() {
        dibujo.eliminar();
        listaPersonas.addObserver(panel);
        listaPersonas.cambioOk();
        logger.debug("Aqui se eliminan las personas de la lista");
    }

}
