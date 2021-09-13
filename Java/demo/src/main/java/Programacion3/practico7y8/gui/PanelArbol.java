package Java.demo.src.main.java.Programacion3.practico7y8.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java.demo.src.main.java.Programacion3.Lista.Lista2;
import Java.demo.src.main.java.Programacion3.practico7y8.dao.DaoExpresion;
import Java.demo.src.main.java.Programacion3.practico7y8.dao.FactoryDao;
import Java.demo.src.main.java.Programacion3.practico7y8.dto.DTOexpresion;
import Java.demo.src.main.java.Programacion3.practico7y8.modelo.Arbol;
import Java.demo.src.main.java.Programacion3.practico7y8.modelo.ArbolAritmetico;
import Java.demo.src.main.java.Programacion3.practico7y8.modelo.ElementoAritmetico;
import Java.demo.src.main.java.Programacion3.practico7y8.modelo.Numero;
import Java.demo.src.main.java.Programacion3.practico7y8.modelo.Operador;

public class PanelArbol extends JPanel implements MouseListener, PropertyChangeListener {

    private final static Logger logger = LogManager.getLogger();

    private ArbolAritmetico modelo;
    private JButton guardarExpresion;
    private JButton eliminarEpresion;
    private DefaultListModel modelList;
    private JList expresiones;
    private JScrollPane scrollExpresiones;

    private PropertyChangeSupport observed;

    public PanelArbol(ArbolAritmetico obj) {
        observed = new PropertyChangeSupport(this);
        modelList = new DefaultListModel<>();
        expresiones = new JList<>();
        scrollExpresiones = new JScrollPane(expresiones);
        scrollExpresiones.setVisible(false);
        JListmostrarExpresiones();
        añadirSelectionListenerJList();
        modelo = obj;
        guardarExpresion = new JButton("Guardar");
        eliminarEpresion = new JButton("Eliminar");
        cargarBotones();
        this.addMouseListener(this);
        this.setLayout(null);
    }

    private void añadirSelectionListenerJList() {
        expresiones.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String elegido = (String) expresiones.getSelectedValue();
                if (elegido != null) {
                    try {
                        modelo = new ArbolAritmetico(elegido);
                        setModelo(modelo);
                        cambioOk();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    public void JListmostrarExpresiones() {
        remove(scrollExpresiones);
        scrollExpresiones.setVisible(true);
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        Lista2<DTOexpresion> lista = daoExpresion.getTodos();
        modelList.clear();
        for (DTOexpresion e : lista) {
            modelList.addElement(e.getExpresion());
        }
        expresiones.setModel(modelList);
        scrollExpresiones = new JScrollPane(expresiones);
        scrollExpresiones.setBounds(10, 0, 120, 480);
        add(scrollExpresiones);
        revalidate();
    }

    public Dimension getPreferredSize() {
        return new Dimension(10000, 10000);
    }

    public void cargarBotones() {
        guardarExpresion.setBounds(175, 438, 90, 40);
        eliminarEpresion.setBounds(295, 438, 90, 40);
        add(guardarExpresion);
        add(eliminarEpresion);
        guardarExpresion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo == null || modelo.getRaiz() == null)
                    return;
                String expresion = modelo.toStringAritmetico(modelo.getRaiz());
                if (expresion != null) {
                    guardarExpresion(expresion);
                }
            }
        });

        eliminarEpresion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo == null || modelo.getRaiz() == null)
                    return;
                String expresion = modelo.toStringAritmetico(modelo.getRaiz());
                System.out.println(expresion);
                if (expresion != null) {
                    eliminarExpresion(expresion);
                }
            }
        });
    }

    public void eliminarExpresion(String expresion) {
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        DTOexpresion dtOexpresion = daoExpresion.getPorExpresion(expresion);
        if (dtOexpresion != null) {
            System.out.println("dtoExpresion");
            daoExpresion.delete(dtOexpresion);
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            this.cambioOk();
        }
        modelo.setRaiz(null);
        modelo.cambioOk();
        modelo = null;
        JListmostrarExpresiones();
    }

    public void guardarExpresion(String expresion) {
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        JTextField nombre = new JTextField();
        Object[] message = { "Nombre Expresion: ", nombre };
        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese nombre a la expresion",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            DTOexpresion dtoExpresion = new DTOexpresion(nombre.getText(), expresion);
            daoExpresion.insert(dtoExpresion);
            this.cambioOk();
            modelo.setRaiz(null);
            modelo.cambioOk();
            modelo = null;
            JListmostrarExpresiones();
            JOptionPane.showMessageDialog(null, "Registro insertado");
        }
    }

    public Arbol.Contenedor<ElementoAritmetico> accederPosicion(Arbol.Contenedor<ElementoAritmetico> contenedor,
            MouseEvent e) {
        Arbol.Contenedor<ElementoAritmetico> seleccionado = null;
        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            seleccionado = accederPosicion(hijo, e);
            if (seleccionado != null) {
                break;
            }
        }
        if (e.getX() >= contenedor.getPosX() && e.getX() <= (contenedor.getPosX() + contenedor.getAnchoContenedor())) {
            if (e.getY() >= contenedor.getPosY()
                    && e.getY() <= (contenedor.getPosY() + contenedor.getAnchoContenedor())) {
                logger.info("Contenedor en X: " + contenedor.getPosX() + " - "
                        + (contenedor.getPosX() + contenedor.getAnchoContenedor()));
                logger.info("Contenedor en Y: " + contenedor.getPosY() + " - "
                        + (contenedor.getPosY() + contenedor.getAnchoContenedor()));
                logger.info("Mous X: " + e.getX() + " Y: " + e.getY());
                ElementoAritmetico elementoAritmetico = contenedor.getContenido();
                if (elementoAritmetico instanceof Numero) {
                    logger.info("Contenido del contenedor: " + ((Numero) elementoAritmetico).getValor());
                } else {
                    Operador operacion = (Operador) elementoAritmetico;
                    String operacionString = operacion.getSimbolo();
                    logger.info("Contenido del contenedor: " + operacionString);
                }
                return contenedor;
            }
        }
        return seleccionado;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null) {
            DibujoArbol dibujoArbol = new DibujoArbol(modelo);
            dibujoArbol.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JListmostrarExpresiones();
        repaint();
    }

    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public void cambioOk() {
        observed.firePropertyChange("Tabla", 1, 2);
    }

    public ArbolAritmetico getModelo() {
        return modelo;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (modelo == null || modelo.getRaiz() == null)
            return;
        Arbol.Contenedor<ElementoAritmetico> raiz = modelo.getRaiz();
        Arbol.Contenedor<ElementoAritmetico> seleccionado = accederPosicion(raiz, e);
        ArbolAritmetico arbolAritmetico = null;
        try {
            if (seleccionado != null) {
                arbolAritmetico = new ArbolAritmetico(modelo.toStringAritmetico(seleccionado));
                arbolAritmetico.setRaiz(seleccionado);
                String operacion = arbolAritmetico.toString();
                logger.info(operacion);
                JOptionPane.showMessageDialog(null, operacion);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void setModelo(ArbolAritmetico modelo) {
        this.modelo = modelo;
        this.modelo.addObserver(this);
        this.modelo.cambioOk();
    }

    /*
     * public String toStringAritmetico(Arbol.Contenedor<ElementoAritmetico> nodo) {
     * ElementoAritmetico elementoAritmetico = nodo.getContenido(); if
     * (elementoAritmetico instanceof Numero) { return String.valueOf(((Numero)
     * elementoAritmetico).getValor()); }
     * 
     * Operador operacion = (Operador) elementoAritmetico; String operacionString =
     * operacion.getSimbolo();
     * 
     * StringBuilder resultado = new StringBuilder(); String separador = ""; for
     * (Arbol.Contenedor<ElementoAritmetico> hijo : nodo.getHijos()) { String
     * hijoString = toStringAritmetico(hijo);
     * resultado.append(separador).append(hijoString); separador = operacionString;
     * } return resultado.toString(); }
     */
    /*
     * public String accederPosicion(Arbol.Contenedor<ElementoAritmetico>
     * contenedor, MouseEvent e) { String resultado = "VACIO"; for
     * (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
     * resultado = accederPosicion(hijo, e); if(!resultado.equals("VACIO")){ break;
     * } }
     * 
     * if (e.getX() >= contenedor.getPosX() && e.getX() <= (contenedor.getPosX() +
     * 40)) { System.out.println("Dentro de los parametros X"); if (e.getY() >=
     * contenedor.getPosY() && e.getY() <= (contenedor.getPosY() + 40)) {
     * System.out.println("Dentro de los parametros Y "); ElementoAritmetico
     * elementoAritmetico = contenedor.getContenido(); if (elementoAritmetico
     * instanceof Numero) { System.out.println(((Numero)
     * elementoAritmetico).getValor()); } else { Operador operacion = (Operador)
     * elementoAritmetico; String operacionString = operacion.getSimbolo();
     * System.out.println(operacionString); } resultado =
     * String.valueOf(modelo.evaluarContenedor(contenedor)); } } return resultado; }
     */
}
