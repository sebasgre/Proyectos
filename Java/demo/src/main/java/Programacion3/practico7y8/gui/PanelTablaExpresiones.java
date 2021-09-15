package Programacion3.practico7y8.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Programacion3.Lista.Lista2;
import Programacion3.practico7y8.dao.DaoExpresion;
import Programacion3.practico7y8.dao.FactoryDao;
import Programacion3.practico7y8.dto.DTOexpresion;
import Programacion3.practico7y8.modelo.ArbolAritmetico;

public class PanelTablaExpresiones extends JPanel implements PropertyChangeListener {

    private JButton insertar;
    private JButton modificar;
    private JButton eliminar;
    private JButton dropear;
    private JTable tabla1;
    private JScrollPane scroll1;
    private Image imagen;
    private PropertyChangeSupport observed;
    private ArbolAritmetico arbol;

    public PanelTablaExpresiones() {
        imagen = new ImageIcon(getClass().getClassLoader().getResource("Java/Programacion3/practico7y8/gui/imagenes/servers.png")).getImage();
        tabla1 = new JTable();
        scroll1 = new JScrollPane(tabla1);
        scroll1.setVisible(false);
        add(scroll1);
        observed = new PropertyChangeSupport(this);
        mostrarTablaExpresiones();
        cargarBotones();
    }

    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public void cambioOk() {
        observed.firePropertyChange("Tabla", 1, 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    private void mostrarTablaExpresiones() {
        remove(scroll1);
        scroll1.setVisible(true);
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        Lista2<DTOexpresion> expresiones = daoExpresion.getTodos();
        Object[] columnas = new Object[]{"Nombre Expresion", "Expresion"};
        DefaultTableModel modelotabla = new DefaultTableModel(columnas, 0);
        for (DTOexpresion e : expresiones) {
            Object[] fila = {e.getNombre(), e.getExpresion()};
            modelotabla.addRow(fila);
        }
        tabla1.setModel(modelotabla);
        scroll1 = new JScrollPane(tabla1);
        scroll1.setBounds(200, 30, 600, 400);
        add(scroll1);
    }

    private void cargarBotones() {
        setLayout(null);
        insertar = new JButton("Insertar");
        modificar = new JButton("Modificar");
        eliminar = new JButton("Eliminar");
        dropear = new JButton("Delete All");
        
        insertar.setBounds(30,30,100,50);
        modificar.setBounds(30, 130,100,50);
        eliminar.setBounds(30,250,100,50);
        dropear.setBounds(30,380,100,50);


        add(insertar);
        add(modificar);
        add(eliminar);
        add(dropear);

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertExpresion();
            }
        });
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateExpresion();
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteExpresion();
            }
        });
        dropear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAll();
            }
        });
    }

    private void deleteAll() {
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        daoExpresion.deleteAll();
        mostrarTablaExpresiones();
        this.cambioOk();
        JOptionPane.showMessageDialog(null, "Registros eliminados");
    }

    private void insertExpresion() {
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        JTextField nombre = new JTextField();
        JTextField expresion = new JTextField();
        Object[] message = {"Nombre Expresion: ", nombre, "Expresion: ", expresion};
        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese la Expresion", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                arbol = new ArbolAritmetico(expresion.getText());
                DTOexpresion dtoExpresion = new DTOexpresion(nombre.getText(), arbol.toStringAritmetico(arbol.getRaiz()));
                daoExpresion.insert(dtoExpresion);
                mostrarTablaExpresiones();
                JOptionPane.showMessageDialog(null, "Registro insertado");
                this.cambioOk();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void updateExpresion() {
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        JTextField nombre = new JTextField();
        JTextField expresion = new JTextField();
        Object[] message = {"Nombre Expresion: ", nombre};
        DTOexpresion dtOexpresion = null;
        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese el nombre_id expresion", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            dtOexpresion = daoExpresion.getPorNombre(nombre.getText());
            nombre.setText(dtOexpresion.getNombre());
            nombre.setEditable(false);
            expresion.setText(dtOexpresion.getExpresion());
            Object[] message2 = {"Nombre Expresion: ", nombre, "Expresion: ", expresion};
            int option2 = JOptionPane.showConfirmDialog(null, message2, "Ingrese nuevos datos", JOptionPane.OK_CANCEL_OPTION);
            if (option2 == JOptionPane.OK_OPTION) {
                try {
                    arbol = new ArbolAritmetico(expresion.getText());
                    dtOexpresion = new DTOexpresion(nombre.getText(), arbol.toStringAritmetico(arbol.getRaiz()));
                    daoExpresion.update(dtOexpresion);
                    mostrarTablaExpresiones();
                    JOptionPane.showMessageDialog(null, "Registro actualizado");
                    this.cambioOk();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void deleteExpresion() {
        FactoryDao factoryDao = FactoryDao.getOrCreate();
        DaoExpresion daoExpresion = factoryDao.getDaoExpresion();
        JTextField nombre = new JTextField();
        Object[] message = {"Nombre Expresion: ", nombre};
        DTOexpresion dtOexpresion = null;
        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese el nombre_id expresion", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            dtOexpresion = daoExpresion.getPorNombre(nombre.getText());
            daoExpresion.delete(dtOexpresion);
            mostrarTablaExpresiones();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            this.cambioOk();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mostrarTablaExpresiones();
    }

    /*
    insert into expresiones values ('x1', '(1.0+(5.0-(1.0*2.0)))');
    insert into expresiones values ('x2', '((1.0+2.0)*((2.0-5.0)/(2.0+(5.0-2.0))))');
    insert into expresiones values ('x3', '(7.0+(3.0-6.0))');
    insert into expresiones values ('x4', '((1.0*2.0)+3.0)');
    insert into expresiones values ('x5', '(4.0^5.0)');
     */
}
