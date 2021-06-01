package prueba.Red;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import prueba.Lista.Lista;
import prueba.Modelo.Mensaje;

import java.io.OutputStream;

public class Enviar implements PropertyChangeListener {
    private Socket sck;
    private PrintWriter out;
    private String mensaje;
    private String nombre;
    private LocalDateTime dateTime;
    private Lista<Mensaje> lista;
    private Mensaje men = new Mensaje(mensaje, nombre, dateTime);

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
        verificador();
        out.println(lista);
        out.flush();
    }

    public void verificador() {
        if (mensaje.contains("<TEXTO>")) {
            lista.add(men);
            lista.cambioOk();
        } else if (mensaje.contains("<IMAGEN>")) {
            try {
                byte[] bytesArchivo = Files.readAllBytes(Paths.get(mensaje));
                OutputStream outputstreamSocket = sck.getOutputStream();
                int inicio = 0;
                int bufsize = 4096;
                int left = bytesArchivo.length;

                while (left > 0) {
                    if (left < bufsize)
                        bufsize = left;

                    outputstreamSocket.write(bytesArchivo, inicio, bufsize);
                    outputstreamSocket.flush();

                    left -= bufsize;
                    inicio += bufsize;
                }
                lista.add(men);
                lista.cambioOk();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public Socket getSck() {
        return sck;
    }
}
