package Animacion.Vista;

import java.awt.Graphics;

import Animacion.Modelo.Figura;

public class DibujoFigura implements IDibujo {

    private Figura objeto;

    public DibujoFigura(Figura f) {
        objeto = f;
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawRect(objeto.getX(), objeto.getY(), objeto.getAncho(), objeto.getAlto());
    }
}
