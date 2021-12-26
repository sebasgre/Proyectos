package Programacion4.POO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar extends JFrame implements ActionListener, Runnable{
    private final JPanel jpPanel = new JPanel();
    private final JButton btnPulsame = new JButton("Pulsame!");
    private final JButton btnSalir = new JButton("Cerrar");
    private final JProgressBar jpBarra = new JProgressBar(0, 100);//indicamos valor minimo y maximo

    public ProgressBar() {
        setSize(300, 100);
        setResizable(false); //no permite cambiar el tamaño de la ventana
        setLocationRelativeTo(null); //aparece en el centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jpBarra.setBounds(5, 10, 280, 25); //configura posicion x, posicion y
        btnPulsame.setBounds(5, 40, 140, 25); // ancho y alto
        btnSalir.setBounds(150, 40, 140, 25); // ancho y alto

        jpBarra.setStringPainted(true); //Agrega el porcentaje en la barra

        jpPanel.setLayout(null); //no aplicamos un gestor de diseño, los componentes tienen su propio lugar determinado, por defecto es flowlayout
        jpPanel.add(jpBarra);
        jpPanel.add(btnPulsame);
        jpPanel.add(btnSalir);
        cargarListeners();
        add(jpPanel);
        setVisible(true);
    }
    public void cargarListeners() {
        btnPulsame.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnSalir))
            System.exit(0);

        if (e.getSource().equals(btnPulsame)) {
            Thread hilo = new Thread(this);
            hilo.start();
            btnPulsame.setEnabled(false);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            jpBarra.setValue(i);
            jpBarra.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ProgressBar();
    }
}
