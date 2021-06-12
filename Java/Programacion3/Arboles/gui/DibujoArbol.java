package Arboles.gui;

import java.awt.Color;
import java.awt.Graphics;
import Animacion.Vista.IDibujo;
import Arboles.Arbol;
import Arboles.Persona;
import Arboles.Arbol.Contenedor;

public class DibujoArbol implements IDibujo {
    public static final int ANCHO_CONTENEDOR = 40;
    public static final int ESPACIO_VERTICAL = 80;
    public static final int ESPACIO_HORIZONTAL = 50;

    private Arbol<Persona> modelo;

    public DibujoArbol(Arbol<Persona> obj) {
        modelo = obj;
    }

    @Override
    public void dibujar(Graphics g) {
        Arbol.Contenedor<Persona> raiz = modelo.getRaiz();
        
        dibujarContenedor(raiz, 10, 10, g);
    }

    public void dibujarContenedor(Arbol.Contenedor<Persona> contenedor, int x, int y, Graphics g) {

        int ancho = getAncho(contenedor);
        int xh = x;
        int yh = y + ESPACIO_VERTICAL;
        int anchoHijo = 0;

        for (Arbol.Contenedor<Persona> hijo : contenedor.getHijos()) {
            anchoHijo = getAncho(hijo);

            g.drawLine(x + ancho / 2, y + ANCHO_CONTENEDOR / 2, xh + anchoHijo / 2, yh + ANCHO_CONTENEDOR / 2);

            dibujarContenedor(hijo, xh, yh, g);

            xh += (anchoHijo + ESPACIO_HORIZONTAL);
        }

        g.setColor(Color.white);
        g.fillArc(x + ancho / 2 - ANCHO_CONTENEDOR / 2, y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);
        g.setColor(Color.black);
        g.drawArc(x + ancho / 2 - ANCHO_CONTENEDOR / 2, y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);
        g.drawString(contenedor.getContenido().getId(), x + ancho / 2, y + ANCHO_CONTENEDOR / 2);

    }

    private int getAncho(Contenedor<Persona> contenedor) {
        if (contenedor.getHijos().tamano() == 0)
            return ANCHO_CONTENEDOR;

        int result = 0;
        int espacio = 0;

        for (Contenedor<Persona> hijo : contenedor.getHijos()) {
            result += espacio + getAncho(hijo);
            espacio = ESPACIO_HORIZONTAL;
        }

        return result;
    }
}
