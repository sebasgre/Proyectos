package Java.Programacion3.Arboles.aritmetico;

import Java.Programacion3.Arboles.Arbol;

public class ArbolAritmetico extends Arbol<ElementoAritmetico> {
    public ArbolAritmetico() {
        super();
    }

    public double evaluar() {
        if (raiz == null)
            return Double.MIN_VALUE;
        return evaluarContenedor(raiz);
    }

    private double evaluarContenedor(Contenedor<ElementoAritmetico> nodo) {
        ElementoAritmetico elementoAritmetico = nodo.getContenido();
        if (elementoAritmetico instanceof Numero) {
            return ((Numero) elementoAritmetico).getValor();
        }

        Operador operacion = (Operador) elementoAritmetico;

        if (operacion.getNombre().equals("Suma")) {
            return sumarHijos(nodo);
        }

        return Double.MIN_VALUE;
    }

    private double sumarHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()) {
            double evaluarHijo = evaluarContenedor(hijo);
            resultado += evaluarHijo;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return toStringAritmetico(raiz) + " = " + String.valueOf(evaluar());
    }

    private String toStringAritmetico(Contenedor<ElementoAritmetico> nodo) {
        ElementoAritmetico elementoAritmetico = nodo.getContenido();
        if (elementoAritmetico instanceof Numero) {
            return String.valueOf(((Numero) elementoAritmetico).getValor());
        }

        Operador operacion = (Operador) elementoAritmetico;
        String operacionString = operacion.getSimbolo();

        StringBuilder resultado = new StringBuilder();
        resultado.append("(");
        String separador = "";
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()) {
            String hijoString = toStringAritmetico(hijo);
            resultado.append(separador).append(hijoString);
            separador = operacionString;
        }
        resultado.append(")");

        return resultado.toString();
    }
}
