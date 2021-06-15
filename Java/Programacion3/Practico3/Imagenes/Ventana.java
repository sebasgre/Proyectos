package Java.Programacion3.Practico3.Imagenes;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java.Programacion3.Practico3.ImagenTransformada.Imagenes;
import Java.Programacion3.Practico3.Red.Enviar;
import Java.Programacion3.Practico3.Red.Recibir;

public class Ventana extends JFrame {
    private final Modelo modelo = new Modelo(600, 400);
    private Enviar conexion;
    private final Imagenes imagenes = new Imagenes(modelo);
    private final PanelImagen panelImagen = new PanelImagen(modelo);
    private final static Logger logger = LogManager.getLogger();

    public Ventana() {
        init();
        this.setTitle("Fill Attack");
    }

    private void init() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem item1 = new JMenuItem("Conectarse");
        JMenuItem item2 = new JMenuItem("Esperar conexion");
        JMenuItem item3 = new JMenuItem("Cargar imagen");
        item1.setEnabled(false);
        item2.setEnabled(false);

        item1.addActionListener(e -> conectarse());

        item2.addActionListener(e -> esperarConexion());

        item3.addActionListener(e -> {
            cargarImagen();
            item1.setEnabled(true);
            item2.setEnabled(true);
        });

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        bar.add(menu);

        modelo.addObserver(panelImagen);
        añadirObservador();
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelImagen, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void cargarImagen() {
        imagenes.hacer();
        logger.info("Aqui se carga la imagen seleccionada del JfileChooser");
    }

    public void conectarse() {
        String ip = JOptionPane.showInputDialog("Coloque la ip");
        int puerto = Integer.parseInt(JOptionPane.showInputDialog(null, "Coloque el puerto"));
        int leerPuerto = leerPuerto(puerto);
        if (leerPuerto == 0) {
            JOptionPane.showMessageDialog(this, "El puerto debe ser un entero mas de 1024");
            return;
        }

        String direccion = leerIP(ip);
        if (direccion.equals("ERROR")) {
            JOptionPane.showMessageDialog(this, "La ip deben ser 4 numeros enteros menores a 255");
            return;
        }
        
        try {
            conexion = new Enviar(ip, leerPuerto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo conectar al servidor con la ip " + ip + " con el puerto " + leerPuerto);
            return;
        }

        Recibir recibir;
        try {
            recibir = new Recibir(conexion.getSck(), modelo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Hubo un error al crear el objeto para recibir, trate de nuevo");
            return;
        }

        try {
            conexion = new Enviar(recibir.getClt());
            panelImagen.setEnviar(conexion);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Hubo un error al crear el objeto para enviar, trate de nuevo");
            return;
        }

        Thread recibiendo = new Thread(recibir);
        recibiendo.start();
        añadirObservador();
        logger.info("Aqui se establece la conexion");
    }

    private void esperarConexion() {
        int puerto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puerto"));
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
                recibir = new Recibir(port, modelo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Hubo un error al crear/esperar la conexión, trate con otro puerto");
                return;
            }

            try {
                conexion = new Enviar(recibir.getClt());
                panelImagen.setEnviar(conexion);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Hubo un error al crear el objeto para enviar, trate de nuevo");
                return;
            }

            Thread recibiendo = new Thread(recibir);
            recibiendo.start();
            añadirObservador();
            logger.info("Aqui el servidor espera que haya una conexion por parte del cliente");
        }
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
        modelo.addObserver(conexion);
    }

}
