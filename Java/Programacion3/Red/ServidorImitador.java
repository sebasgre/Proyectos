package Red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorImitador {
    public static final int PUERTO = 6849;

    public static void main(String[] args) throws IOException {

        ServerSocket srv = new ServerSocket(PUERTO);
        Socket cltSocket = srv.accept();

        PrintWriter out = new PrintWriter(cltSocket.getOutputStream());
        out.flush();

        BufferedReader inReader = new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));

        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        String entrada = entradaReader.readLine();

        while(!cltSocket.isClosed()) {
            // Envia
            out.println(entrada);
            out.flush();
            System.out.println("Servidor envia de coordenadas: " + entrada);
            // Recibe
            String solicitud = inReader.readLine();
            System.out.println("Recibe de cliente las coordenadas: " + solicitud);
            if (solicitud == null)
                break;
        }

        inReader.close();
        out.close();
        cltSocket.close();
        srv.close();
    }
}
