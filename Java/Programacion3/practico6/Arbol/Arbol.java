package Java.Programacion3.practico6.Arbol;

import Java.Programacion3.Lista.Lista2;
import Java.Programacion3.practico6.gui.Identificable;

public class Arbol<T extends Identificable> {
    protected Contenedor<T> raiz;

    public Contenedor<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Contenedor<T> raiz) {
        this.raiz = raiz;
    }

    public void addHijo(T o, String padre) {
        if (padre == null) {
            raiz = new Contenedor<>(o);
            return;
        }

        Contenedor<T> hijo = new Contenedor<>(o);

        Contenedor<T> contenedorPadre = buscar(padre);
        contenedorPadre.getHijos().insertar(hijo);
        hijo.setPadre(contenedorPadre);
    }

    private Contenedor<T> buscar(String padre) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscar(padre);
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "VACIO";
        }
        return raiz.toString();
    }

    public static class Contenedor<T extends Identificable> {

        private T contenido;
        private Lista2<Contenedor<T>> hijos;
        private Contenedor<T> padre;
        private int posX;
        private int posY;

        public Contenedor(T contenido) {
            this.contenido = contenido;
            hijos = new Lista2<>();
            padre = null;
        }

        public T getContenido() {
            return contenido;
        }

        public void setContenido(T contenido) {
            this.contenido = contenido;
        }

        public Lista2<Contenedor<T>> getHijos() {
            return hijos;
        }

        public void setHijos(Lista2<Contenedor<T>> hijos) {
            this.hijos = hijos;
        }

        public Contenedor<T> getPadre() {
            return padre;
        }

        public void setPadre(Contenedor<T> padre) {
            this.padre = padre;
        }

        public int getPosX() {
            return posX;
        }

        public void setPosX(int posX) {
            this.posX = posX;
        }

        public int getPosY() {
            return posY;
        }

        public void setPosY(int posY) {
            this.posY = posY;
        }

        public Contenedor<T> buscar(String id) {
            if (contenido.getId().equals(id))
                return this;
            for (Contenedor<T> hijo : hijos) {
                Contenedor<T> posible = hijo.buscar(id);
                if (posible != null) {
                    return posible;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            StringBuilder respuesta = new StringBuilder();
            respuesta.append(this.getContenido().getId());
            if (hijos.tamano() > 0) {
                respuesta.append("(");
                String separador = "";
                for (Contenedor<T> hijo : hijos) {
                    respuesta.append(separador).append(hijo.toString());
                    separador = ",";
                }
                respuesta.append(")");
            }
            return respuesta.toString();
        }
    }
}