package Java.demo.src.main.java.Programacion3.prueba.Red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Recibir implements Runnable {
    private Socket clt;
    private BufferedReader in;

    public Recibir(int port) throws IOException {

        ServerSocket srv = null;
        clt = null;

        try {
            srv = new ServerSocket(port);
        } catch (IOException e) {
            throw e;
        }

        try {
            clt = srv.accept();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                srv.close();
            } catch (IOException e) {
                throw e;
            }
        }
        in = new BufferedReader(new InputStreamReader(clt.getInputStream()));

    }

    public Recibir(Socket sck) throws IOException {
        clt = sck;
        in = new BufferedReader(new InputStreamReader(clt.getInputStream()));
    }

    public Socket getClt() {
        return clt;
    }

    @Override
    public void run() {
        while (!clt.isClosed()) {

        }
    }
}
