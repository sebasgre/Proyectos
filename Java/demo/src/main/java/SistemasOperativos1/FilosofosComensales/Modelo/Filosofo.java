package SistemasOperativos1.FilosofosComensales.Modelo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Filosofo implements Runnable {
    private int cantidadDeComidas = 5;
    private int id, res;
    private Thread t;
    private JButton filosofo;
    private JLabel derecho;
    private JLabel izquierdo;
    private JLabel resultado;
    private String proceso;
    private JTextArea textArea;
    private JLabel porcentaje;

    public Filosofo(int id, JLabel izquierdo, JLabel derecho, JButton filosofo, JLabel porcentaje, JLabel resultado,
            JTextArea textArea) {
        this.id = id;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
        this.filosofo = filosofo;
        this.porcentaje = porcentaje;
        this.resultado = resultado;
        this.textArea = textArea;
        this.filosofo.setBackground(Color.white);
        t = new Thread(this);
        t.start();

    }

    public void run() {
        for (int i = 0; i < cantidadDeComidas; i++) {
            synchronized (this.izquierdo) {
                synchronized (this.derecho) {
                    comer();
                }
            }
            pensar();
        }
    }

    void comer() {
        derecho.setText("Ocupado");
        derecho.setForeground(Color.red);

        izquierdo.setText("Ocupado");
        izquierdo.setForeground(Color.red);

        filosofo.setText("Comiendo");
        filosofo.setBackground(Color.GREEN);

        res = Integer.parseInt(resultado.getText());
        res += 1;
        resultado.setText(String.valueOf(res));
        proceso = "Fil.= " + (id + 1) + " Comiendo usa sus tenedores\n";
        textArea.append(proceso);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        porcentaje.setText(String.valueOf((res * 100) / cantidadDeComidas) + "%");
        derecho.setText("Libre");
        derecho.setForeground(Color.black);

        izquierdo.setText("Libre");
        izquierdo.setForeground(Color.black);

        filosofo.setText("Pensando");
        filosofo.setBackground(Color.white);
        proceso = "Fil.= " + (id + 1) + " Deja de comer y queda pensando, libera sus tenedores\n";
        textArea.append(proceso);
        if(res == cantidadDeComidas){
            filosofo.setText("FELIZ");
            filosofo.setBackground(Color.yellow);
        }
    }

    void pensar() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}
