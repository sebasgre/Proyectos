package Programacion3.Red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteImitador {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket cltSocket = new Socket("127.0.0.1", ServidorImitador.PUERTO);

        PrintWriter out = new PrintWriter(cltSocket.getOutputStream());
        out.flush();

        BufferedReader inReader = new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));

        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        String entrada = entradaReader.readLine();

        while(!entrada.equals("FIN")) {
            // Envia
            out.println(entrada);
            out.flush();
            System.out.println("Cliente envia de coordenadas " + entrada);
            //Recibe
            String respuesta = inReader.readLine();
            System.out.println("Recibe de servidor las coordenadas: " + respuesta);

            entrada = entradaReader.readLine();
        }
        inReader.close();
        out.close();
        cltSocket.close();
    }
}
