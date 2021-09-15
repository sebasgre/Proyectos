package Programacion3.Practico1.Vista;

import java.awt.Graphics;

import Programacion3.Practico1.Modelo.Linea;

public class DibujoLinea implements IDibujo {
    private Linea[] lineas;

    public DibujoLinea(Linea[] la) {
        lineas = la;
    }


    @Override
    public void dibujo(Graphics g) {
        for (Linea li : lineas) {
            if (li != null)
                g.drawLine(li.getX(), li.getY(), li.getX(), 400 - li.getAlto());
        }
    }
}
