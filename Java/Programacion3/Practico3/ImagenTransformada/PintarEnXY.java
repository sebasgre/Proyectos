package Practico3.ImagenTransformada;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Practico3.Imagenes.Modelo;

public class PintarEnXY extends Transformacion {
    private int x;
    private int y;
    private boolean control;
    private final static Logger logger = LogManager.getLogger();

    public PintarEnXY(Modelo img, int x, int y) {
        modeloBase = img;
        this.x = x;
        this.y = y;
    }

    public void pintaPuntoXY(int m, int n, int colorBase) {
        int base = colorBase;
        int c = modeloBase.getPixel(m, n);
        if (base < 0) {
            base = c;
            modeloBase.setPixel(0X00ffffff, m, n);
        }

        if ((m + 1) < modeloBase.getAncho() && modeloBase.getPixel(m + 1, n) == base)
            pintaPuntoXY(m + 1, n, base);
        if ((m - 1) >= 0 && modeloBase.getPixel(m - 1, n) == base)
            pintaPuntoXY(m - 1, n, base);
        if ((n + 1) < modeloBase.getAlto() && modeloBase.getPixel(m, n + 1) == base)
            pintaPuntoXY(m, n + 1, base);
        if ((n - 1) >= 0 && modeloBase.getPixel(m, n - 1) == base)
            pintaPuntoXY(m, n - 1, base);
    }

    public void verificarGanador() {
        int gana = ((modeloBase.getAncho()) * modeloBase.getAlto() * 51) / 100;
        int contador = 0;
        for (int i = 0; i < modeloBase.getAncho(); i++) {
            for (int j = 0; j < modeloBase.getAlto(); j++) {
                int blanco = modeloBase.getPixel(i,j);
                if (blanco == 0X00ffffff){
                    contador++;
                    if (contador == gana) {
                        control = true;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void hacer() {
        try {
            pintaPuntoXY(x, y, -1);
            verificarGanador();
            if (control == true) {
                JOptionPane.showMessageDialog(null, "HAS GANADO EL JUEGO");
                    System.exit(0);
                    logger.info("Aqui verificamos al ganador, donde quedara la imagen sola");
            }
        } catch (StackOverflowError ex) {
            //System.out.println("Termina por stack overflow");
        }
        modeloBase.cambioOk();
    }
}
