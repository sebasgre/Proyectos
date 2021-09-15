package Programacion3.practico6.view;

import java.awt.Color;
import java.awt.Graphics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Programacion3.Practico4.Vista.IDibujo;
import Programacion3.practico6.Arbol.Arbol;
import Programacion3.practico6.aritmetico.ElementoAritmetico;
import Programacion3.practico6.aritmetico.Numero;
import Programacion3.practico6.aritmetico.Operador;
import Programacion3.practico6.modelo.ArbolAritmetico;

public class DibujoArbol implements IDibujo {

    public static final int ANCHO_CONTENEDOR = 40;
    public static final int ESPACIO_VERTICAL = 80;
    public static final int ESPACIO_HORIZONTAL = 50;
    private final static Logger logger = LogManager.getLogger();
    private ArbolAritmetico modelo;

    public DibujoArbol(ArbolAritmetico obj) {
        modelo = obj;
    }

    public void dibujarContenedor(Arbol.Contenedor<ElementoAritmetico> contenedor, int x, int y, Graphics g) {
        int ancho = getAncho(contenedor);
        int xh = x;
        int yh = y + ESPACIO_VERTICAL;
        int anchoHijo = 0;

        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            anchoHijo = getAncho(hijo);

            // lineas
            g.setColor(Color.WHITE);
            g.drawLine(x + (ancho / 2), y + ANCHO_CONTENEDOR / 2, xh + anchoHijo / 2, yh + ANCHO_CONTENEDOR);

            dibujarContenedor(hijo, xh, yh, g);
            xh += (anchoHijo + ESPACIO_HORIZONTAL);
        }

        g.setColor(Color.ORANGE);
        g.fillArc(x + (ancho / 2) - (ANCHO_CONTENEDOR / 2), y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);
        g.setColor(Color.RED);
        g.drawArc(x + (ancho / 2) - (ANCHO_CONTENEDOR / 2), y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);

        contenedor.setPosX(x + (ancho / 2) - (ANCHO_CONTENEDOR / 2));
        contenedor.setPosY(y);

        ElementoAritmetico elementoAritmetico = contenedor.getContenido();
        g.setColor(Color.BLACK);
        if (elementoAritmetico instanceof Numero) {
            g.drawString(String.valueOf(((Numero) elementoAritmetico).getValor()), x + (ancho / 2) - 5,
                    y + (ANCHO_CONTENEDOR / 2) + 4);
        } else {
            Operador operacion = (Operador) elementoAritmetico;
            String operacionString = operacion.getSimbolo();
            g.drawString(operacionString, x + (ancho / 2) - 5, y + (ANCHO_CONTENEDOR / 2) + 4);
        }
    }

    private int getAncho(Arbol.Contenedor<ElementoAritmetico> contenedor) {
        if (contenedor.getHijos().tamano() == 0)
            return ANCHO_CONTENEDOR;

        int result = 0;
        int espacio = 0;
        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            result += espacio + getAncho(hijo);
            espacio = ESPACIO_HORIZONTAL;
        }
        return result;
    }

    @Override
    public void dibujo(Graphics g) {
        Arbol.Contenedor<ElementoAritmetico> raiz = modelo.getRaiz();
        dibujarContenedor(raiz, 10, 10, g);
        logger.debug("Aqui se dibuja cada nodo");

    }

    @Override
    public void eliminar() {
        // TODO Auto-generated method stub

    }
}
