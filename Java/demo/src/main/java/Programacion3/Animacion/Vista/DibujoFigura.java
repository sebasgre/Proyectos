package Java.demo.src.main.java.Programacion3.Animacion.Vista;

import java.awt.Graphics;

import Java.demo.src.main.java.Programacion3.Animacion.Modelo.Figura;

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
