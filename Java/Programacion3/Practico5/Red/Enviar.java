package Practico5.Red;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Enviar implements PropertyChangeListener {
    private Socket sck;
    private PrintWriter out;

    public Enviar(String ip, int puerto) throws IOException {
        try {
            sck = new Socket(ip, puerto);
        } catch (IOException e) {
            throw e;
        }

        try {
            out = new PrintWriter(new java.io.OutputStreamWriter(sck.getOutputStream()));
        } catch (IOException e) {
            throw e;
        }
    }

    public Enviar(Socket sck) throws IOException {
        this.sck = sck;
        try {
            out = new PrintWriter(new java.io.OutputStreamWriter(sck.getOutputStream()));
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // if (check1 && check2) {
        // out.println(posX + "|" + posY);
        out.flush();
        // }
    }

    public Socket getSck() {
        return sck;
    }
}
