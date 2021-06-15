package Java.Programacion3.prueba.Vista;

import java.awt.Graphics;

public class Dibujo implements iDibujo {

    @Override
    public void dibujo(Graphics g) {
        // TODO Auto-generated method stub
        
    }
    /*private Lista<Mensaje> lista;
    private Enviar conexion;
    private String texto;
    private int distaciaEntreLineas = 15;
    private boolean usuarioRemoto;
    private boolean enviado;
    public static final int ANCHO_MENSAJE = 275;

    public Dibujo(Lista<Mensaje> l) {
        lista = l;
    }

    public Lista cortarMensaje() {
        int numLineas = texto.length() / 40;
        Lista<String> lineas = new Lista<>();
        for (int i = 0; i <= numLineas; i++){
            if(i == numLineas){
                lineas.add(texto.substring(i*40));
                break;
            }
            lineas.add(texto.substring(i*40, i*40 + 40));
        }
        return lineas;
    }

    public int getAlto(){
        Lista<String> lineas = cortarMensaje();
        return lineas.tamano() * distaciaEntreLineas;
    }



    @Override
    public void dibujo(Graphics g) {
         Lista<String> lineas = cortarMensaje();
        int alto = getAlto();
        int izquierdaPosX = 10;
        int derechaPosX = 315;
        if (usuarioRemoto) {
            g.setColor(Color.yellow);
            g.fillRoundRect(izquierdaPosX, posY, ANCHO_MENSAJE, alto, 20, 20);

            drawTextos(g, lineas, izquierdaPosX, posY + 10);
        } else {
            g.setColor(Color.green);
            g.fillRoundRect(derechaPosX, posY, ANCHO_MENSAJE, alto, 20, 20);

            drawTextos(g, lineas, derechaPosX, posY + 10);
        }
    }*/

}
