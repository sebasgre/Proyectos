package SQL.BD1.Proyecto.gui;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java.demo.src.main.java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dao.DAOarbitros;
import SQL.BD1.Proyecto.dao.DAOclasifican;
import SQL.BD1.Proyecto.dao.DAOdirectoresAdmins;
import SQL.BD1.Proyecto.dao.DAOdirectoresTecnicos;
import SQL.BD1.Proyecto.dao.DAOequipos;
import SQL.BD1.Proyecto.dao.DAOestadios;
import SQL.BD1.Proyecto.dao.DAOetapas;
import SQL.BD1.Proyecto.dao.DAOjugadores;
import SQL.BD1.Proyecto.dao.DAOpartidos;
import SQL.BD1.Proyecto.dao.DAOpartidosArbitros;
import SQL.BD1.Proyecto.dao.DAOpresidentes;
import SQL.BD1.Proyecto.dao.DAOtipoRegistro;
import SQL.BD1.Proyecto.dto.DTOarbitros;
import SQL.BD1.Proyecto.dto.DTOclasifican;
import SQL.BD1.Proyecto.dto.DTOdirectoresAdmins;
import SQL.BD1.Proyecto.dto.DTOdirectoresTecnicos;
import SQL.BD1.Proyecto.dto.DTOequipos;
import SQL.BD1.Proyecto.dto.DTOestadios;
import SQL.BD1.Proyecto.dto.DTOetapas;
import SQL.BD1.Proyecto.dto.DTOjugadores;
import SQL.BD1.Proyecto.dto.DTOpartidos;
import SQL.BD1.Proyecto.dto.DTOpartidosArbitros;
import SQL.BD1.Proyecto.dto.DTOpresidentes;
import SQL.BD1.Proyecto.dto.DTOtipoRegistro;

public class Ventana extends JFrame {
    private Panel panel;
    private DefaultTableModel modelotabla;
    private JTable tabla1;
    private JScrollPane scroll1;
    private JScrollPane scroll2;
    private Object columnas[];
    private JList equi;
    private DefaultListModel modelList;
    private final static Logger logger = LogManager.getRootLogger();

    public Ventana() {
        super("Proyecto: UEFA Champions League");
        init();
    }

    private void init() {
        panel = new Panel();
        columnas = null;
        modelotabla = new DefaultTableModel(columnas, 0);
        tabla1 = new JTable(modelotabla);
        scroll1 = new JScrollPane(tabla1);
        scroll1.setVisible(false);
        modelList = new DefaultListModel<>();
        equi = new JList<>();
        scroll2 = new JScrollPane(equi);
        scroll2.setVisible(false);
        panel.add(scroll1);
        panel.add(scroll2);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem jugadores = new JMenuItem("Tabla Jugadores");
        JMenuItem arbitros = new JMenuItem("Tabla Arbitros");
        JMenuItem partidos = new JMenuItem("Tabla Partidos");
        JMenuItem clasifican = new JMenuItem("Tabla Clasifican");
        JMenuItem directoresAdmins = new JMenuItem("Tabla DirectoresAdmins");
        JMenuItem directoresTecnicos = new JMenuItem("Tabla DirectoresTecnicos");
        JMenuItem equipos = new JMenuItem("Tabla Equipos");
        JMenuItem estadios = new JMenuItem("Tabla Estadios");
        JMenuItem etapas = new JMenuItem("Tabla Etapas");
        JMenuItem partidosArbitros = new JMenuItem("Tabla PartidosArbitros");
        JMenuItem presidentes = new JMenuItem("Tabla Presidentes");
        JMenuItem tipoRegistro = new JMenuItem("Tabla TipoRegistro");
        JMenuItem quitarTabla = new JMenuItem("Quitar Tabla");
        JMenuItem salir = new JMenuItem("Salir");

        jugadores.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOjugadores dao = new DAOjugadores();
            Lista2<DTOjugadores> personas = dao.getTodos();

            columnas = new Object[] { "DNI", "Nombre", "Sueldo", "Sexo", "NumDorsal", "Equipos_id" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOjugadores p : personas) {
                Object[] fila = { p.getDni(), p.getNombre(), p.getSueldo(), p.getSexo(), p.getNumDorsal(),
                        p.getEquipos_id() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
            panel.remove(scroll2);
            scroll2.setVisible(true);
            DAOequipos dao2 = new DAOequipos();
            Lista2<DTOequipos> listaEquipos = dao2.getTodos();
            modelList = new DefaultListModel<>();
            for (DTOequipos eq : listaEquipos) {
                modelList.addElement(eq.getNombre());
            }
            equi.setModel(modelList);
            scroll2 = new JScrollPane(equi);
            scroll2.setBounds(905, 100, 120, 400);
            panel.add(scroll2);
            revalidate();
            equi.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    String elegido = (String) equi.getSelectedValue();
                    panel.remove(scroll1);
                    scroll1.setVisible(true);
                    DAOjugadores dao = new DAOjugadores();
                    Lista2<DTOjugadores> personas = dao.getPorEquipos(elegido);

                    columnas = new Object[] { "DNI", "Nombre", "Sueldo", "Sexo", "NumDorsal", "Equipos_id" };
                    modelotabla = new DefaultTableModel(columnas, 0);
                    for (DTOjugadores p : personas) {
                        Object[] fila = { p.getDni(), p.getNombre(), p.getSueldo(), p.getSexo(), p.getNumDorsal(),
                                p.getEquipos_id() };
                        modelotabla.addRow(fila);
                    }
                    tabla1 = new JTable(modelotabla);
                    scroll1 = new JScrollPane(tabla1);
                    scroll1.setBounds(100, 100, 800, 400);
                    panel.add(scroll1);
                }
            });
        });

        arbitros.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOarbitros dao = new DAOarbitros();
            Lista2<DTOarbitros> personas = dao.getTodos();
            columnas = new Object[] { "DNI", "Nombre", "Sueldo", "Sexo", "Peso", "f_nacimiento", "Altura" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOarbitros p : personas) {
                Object[] fila = { p.getDni(), p.getNombre(), p.getSueldo(), p.getSexo(), p.getPeso(),
                        p.getF_nacimiento(), p.getAltura() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        partidos.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOpartidos dao = new DAOpartidos();
            Lista2<DTOpartidos> personas = dao.getTodos();

            columnas = new Object[] { "numPartido", "f_partido", "equiposVisitante_id", "equiposLocales_id",
                    "estadios_id" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOpartidos p : personas) {
                Object[] fila = { p.getNumPartido(), p.getF_partido(), p.getEquiposVisitantes_id(),
                        p.getEquiposLocales_id(), p.getEstadios_id() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        clasifican.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOclasifican dao = new DAOclasifican();
            Lista2<DTOclasifican> personas = dao.getTodos();
            columnas = new Object[] { "equipos_id", "etapas_id", "Fecha" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOclasifican p : personas) {
                Object[] fila = { p.getEquipos_id(), p.getEtapas_id(), p.getFecha() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        directoresAdmins.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOdirectoresAdmins dao = new DAOdirectoresAdmins();
            Lista2<DTOdirectoresAdmins> personas = dao.getTodos();
            columnas = new Object[] { "dni", "nombre" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOdirectoresAdmins p : personas) {
                Object[] fila = { p.getDni(), p.getNombre() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        directoresTecnicos.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOdirectoresTecnicos dao = new DAOdirectoresTecnicos();
            Lista2<DTOdirectoresTecnicos> personas = dao.getTodos();
            columnas = new Object[] { "dni", "nombre" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOdirectoresTecnicos p : personas) {
                Object[] fila = { p.getDni(), p.getNombre() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        equipos.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOequipos dao = new DAOequipos();
            Lista2<DTOequipos> personas = dao.getTodos();
            columnas = new Object[] { "codigo", "nombre", "pais", "presidente_id", "directoresTecnicos_id" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOequipos p : personas) {
                Object[] fila = { p.getCodigo(), p.getNombre(), p.getPais(), p.getPresidente_id(),
                        p.getDirectoresTecnicos_id() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        estadios.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOestadios dao = new DAOestadios();
            Lista2<DTOestadios> personas = dao.getTodos();
            columnas = new Object[] { "nombreEstadio", "centroDeportivo" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOestadios p : personas) {
                Object[] fila = { p.getNombreEstadio(), p.getCentroDeportivo() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        etapas.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOetapas dao = new DAOetapas();
            Lista2<DTOetapas> personas = dao.getTodos();
            columnas = new Object[] { "numEtapa", "nombreEtapa", "directoresAdmins_id" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOetapas p : personas) {
                Object[] fila = { p.getNumEtapa(), p.getNombreEtapa(), p.getDirectoresAdmins_id() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        partidosArbitros.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOpartidosArbitros dao = new DAOpartidosArbitros();
            Lista2<DTOpartidosArbitros> personas = dao.getTodos();
            columnas = new Object[] { "partidos_id", "arbitros_id", "rolPartido" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOpartidosArbitros p : personas) {
                Object[] fila = { p.getPartidos_id(), p.getArbitros_id(), p.getRolPartido() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        presidentes.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOpresidentes dao = new DAOpresidentes();
            Lista2<DTOpresidentes> personas = dao.getTodos();
            columnas = new Object[] { "dni", "nombre" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOpresidentes p : personas) {
                Object[] fila = { p.getDni(), p.getNombre() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        tipoRegistro.addActionListener(e -> {
            panel.remove(scroll1);
            scroll1.setVisible(true);
            DAOtipoRegistro dao = new DAOtipoRegistro();
            Lista2<DTOtipoRegistro> personas = dao.getTodos();
            columnas = new Object[] { "jugadores_id", "partidos_id", "posicion", "numGoles", "numAsistencias",
                    "minutoIncidente", "tipoTarjeta", "minutosJugados" };
            modelotabla = new DefaultTableModel(columnas, 0);
            for (DTOtipoRegistro p : personas) {
                Object[] fila = { p.getJugadores_id(), p.getPartidos_id(), p.getPosicion(), p.getNumGoles(),
                        p.getNumAsistencias(), p.getMinutoIncidente(), p.getTipoTarjeta(), p.getMinutosJugados() };
                modelotabla.addRow(fila);
            }
            tabla1 = new JTable(modelotabla);
            scroll1 = new JScrollPane(tabla1);
            scroll1.setBounds(100, 100, 800, 400);
            panel.add(scroll1);
        });

        quitarTabla.addActionListener(e -> {
            panel.remove(scroll1);
        });

        salir.addActionListener(e -> {
            salir();
        });

        menu.add(jugadores);
        menu.add(arbitros);
        menu.add(partidos);
        menu.add(clasifican);
        menu.add(directoresAdmins);
        menu.add(directoresTecnicos);
        menu.add(equipos);
        menu.add(estadios);
        menu.add(etapas);
        menu.add(partidosArbitros);
        menu.add(presidentes);
        menu.add(tipoRegistro);
        menu.add(quitarTabla);
        menu.add(salir);
        bar.add(menu);
        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void nuevaPersona() {
        JTextField nombreField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField alturaField = new JTextField();
        JTextField generoField = new JTextField();

        Object[] message = { "Nombre: ", nombreField, "Edad: ", edadField, "Altura: ", alturaField, "Genero: ",
                generoField };

        int option = JOptionPane.showConfirmDialog(null, message, "Nueva persona", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            /*
             * if (validarCampos(edadField.getText(), alturaField.getText(),
             * generoField.getText()) == 1) { int edad =
             * Integer.parseInt(edadField.getText()); int altura =
             * Integer.parseInt(alturaField.getText()); String mensaje = ""; if (edad > 100
             * || altura > 250) { mensaje += edad < 101 ? "" :
             * "La edad debe ser menor a 100 años.\n"; mensaje += altura < 250 ? "" :
             * "La altura debe ser menor a 250 cm.";
             * JOptionPane.showMessageDialog(panelDibujoListaPersonas, mensaje);
             * logger.info(mensaje); return; }
             * 
             * Persona p = new Persona(nombreField.getText(), generoField.getText(), edad,
             * altura); personas.insertar(p); p.addObserver(panelDibujoListaPersonas);
             * p.cambioOk(); logger.debug("Se añadio a : " + "Nombre: " +
             * nombreField.getText() + " Edad: " + edad + " Altura: " + altura + " Genero: "
             * + generoField.getText()); }
             */
        }
    }

    private void salir() {
        System.exit(EXIT_ON_CLOSE);
        logger.info("Salir");
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
