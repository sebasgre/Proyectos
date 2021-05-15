package Practico3.Red;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Practico3.ImagenTransformada.PintarEnXY;
import Practico3.Imagenes.Modelo;

public class Recibir implements Runnable {
    private Modelo imagen;
    private Socket clt;
    private BufferedReader in;

    public Recibir(int port, Modelo imagen) throws IOException {
        ServerSocket srv = new ServerSocket(port);
        clt = srv.accept();
        in = new BufferedReader(new InputStreamReader(clt.getInputStream()));
        this.imagen = imagen;
    }

    public Recibir(Socket sck, Modelo imagen) throws IOException {
        clt = sck;
        in = new BufferedReader(new InputStreamReader(clt.getInputStream()));
        this.imagen = imagen;
    }

    public Socket getClt() {
        return clt;
    }

    @Override
    public void run() {
        try {
            PintarEnXY pinta;
            while (!clt.isClosed()) {
                String coordenadas = in.readLine();
                String[] posiciones = coordenadas.split("\\|");
                int x = Integer.parseInt(posiciones[0]);
                int y = Integer.parseInt(posiciones[1]);
                pinta = new PintarEnXY(imagen, x, y);
                pinta.hacer();
            }
        } catch (IOException e) {
        }
    }
}

