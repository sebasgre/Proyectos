package Programacion3.Practico3.Red;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Enviar implements PropertyChangeListener {
    private Socket sck;
    private PrintWriter out;
    private int posX;
    private int posY;
    private boolean check1;
    private boolean check2;
    private final static Logger logger = LogManager.getLogger();

    public Enviar(String ip, int puerto) throws IOException {
        sck = new Socket(ip, puerto);
        out = new PrintWriter(new java.io.OutputStreamWriter(sck.getOutputStream()));
    }

    public Enviar(Socket sck) throws IOException {
        this.sck = sck;
        out = new PrintWriter(new java.io.OutputStreamWriter(sck.getOutputStream()));
    }

    public void setPosX(int posX) {
        this.posX = posX;
        check1 = true;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        check2 = true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (check1 && check2) {
            out.println(posX + "|" + posY);
            out.flush();
            logger.info("Aqui se envia las coordenadas " + posX + " |" + posY);
            check1 = false;
            check2 = false;
        }
    }

    public Socket getSck() {
        return sck;
    }

}
