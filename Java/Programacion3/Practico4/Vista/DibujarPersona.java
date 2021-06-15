package Java.Programacion3.Practico4.Vista;

import java.awt.Color;
import java.awt.Graphics;

import Java.Programacion3.Practico4.Lista.ListaOrdenada;
import Java.Programacion3.Practico4.Modelo.Persona;

public class DibujarPersona implements IDibujo {
    private ListaOrdenada<Persona> lista;

    public DibujarPersona(ListaOrdenada<Persona> p) {
        lista = p;
    }

    public void eliminar() {
        lista = new ListaOrdenada<>();
    }

    @Override
    public void dibujo(Graphics g) {
        int x = 25;
        for (Persona p : lista) {
            int puntoY = 250;
            int altura = p.getAltura();
            int anchoBrazo;
            int anchoCabeza;
            int largoDePiernas = ((altura * 40) / 100);
            int largoDeTorso = ((altura * 35) / 100);
            int largoDeCabeza = (altura * 25) / 100;
            anchoBrazo = largoDeCabeza;
            anchoCabeza = largoDeCabeza;
            if (p.getGenero().toLowerCase().equals("femenino")) {
                g.setColor(Color.MAGENTA);
                g.fillRect(x + (anchoCabeza / 3) * 2, puntoY - largoDePiernas - largoDeTorso - largoDeCabeza + (largoDeCabeza / 3), (largoDeCabeza / 3), largoDeCabeza - 7);//pelo
            }

            Color color;
            if (p.getEdad() < 15) {
                color = new Color(55, 190, 86);
                g.setColor(color);
            }else if(p.getEdad() > 14 && p.getEdad() < 25) {
                int red = ((55 + 255) / 2) - p.getEdad();
                int green = ((190 + 255) / 2) - p.getEdad();
                int blue = ((86) / 2) - p.getEdad();
                color = new Color(red << 16 | green << 8 | blue);
                g.setColor(color);
            }else if(p.getEdad() > 24 && p.getEdad() < 60) {
                int red = ((55 + 255) / 2) - p.getEdad();
                int green = ((190 + 255) / 2) - p.getEdad();
                int blue = ((86) / 2) - p.getEdad();
                color = new Color(red << 16 | green << 8 | blue);
                g.setColor(color);
            }else {
                color = new Color(255,255,0);
                g.setColor(color);
            }

            g.drawLine(x, puntoY, x + (anchoBrazo / 2), puntoY - largoDePiernas);//Pierna izquierda
            g.drawLine(x + (anchoBrazo / 2), puntoY - largoDePiernas, x + anchoBrazo, puntoY);//Pierna Derecha
            g.drawLine(x + (anchoBrazo / 2), puntoY - largoDePiernas, x + (anchoBrazo / 2), puntoY - largoDePiernas - largoDeTorso);//Torso
            g.drawLine(x, puntoY - largoDePiernas - largoDeTorso + ((largoDeTorso * 10) / 35), x + anchoBrazo, puntoY - largoDePiernas - largoDeTorso + ((largoDeTorso * 10) / 35));//Brazos
            g.drawOval(x, puntoY - largoDePiernas - largoDeTorso - largoDeCabeza, anchoCabeza, largoDeCabeza);//Cabeza
            x += anchoBrazo + 35;
        }
    }
}
