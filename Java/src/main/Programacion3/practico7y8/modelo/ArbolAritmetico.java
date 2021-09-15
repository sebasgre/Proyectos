package Programacion3.practico7y8.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ArbolAritmetico extends Arbol<ElementoAritmetico> {
    // Todo lo de arbol
    // MÁS operaciones especificas de arbol aritmetico

    private PropertyChangeSupport observed;

    public ArbolAritmetico() {
        super();
    }
    public ArbolAritmetico(String expresion) throws Exception {
        raiz = leerExpresion(null, expresion);
        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener panel){
        observed.addPropertyChangeListener(panel);
    }

    public void cambioOk() {
        observed.firePropertyChange("Modelo", 1, 2);
    }

    public Contenedor<ElementoAritmetico> leerExpresion(
            Contenedor<ElementoAritmetico> padre, String expresionSucia)
            throws Exception {
        String expresion = expresionSucia.trim();

        int largo = expresion.length();

        int posicionActual = 0;
        int conteoParentesis = 0;

        double posibleNumeroExpresion = Double.MIN_VALUE;
        try {
            posibleNumeroExpresion =  Double.parseDouble(expresion);
            Contenedor<ElementoAritmetico> resultadoNodo =
                    new Contenedor<>(new Numero(posibleNumeroExpresion));
            resultadoNodo.setPadre(padre);
            return resultadoNodo;
        } catch (Exception e) {
            // Nada
        }

        while(posicionActual < largo) {

            char caracterActual = expresion.charAt(posicionActual);

            if (caracterActual == ' ' || caracterActual == '\t') {
                posicionActual++;
                continue;
            }

            if (caracterActual == '.') {
                posicionActual++;
                continue;
            }

            int numero = Integer.MIN_VALUE;
            try {
                numero = Integer.parseInt(String.valueOf(caracterActual));
                // posible numero
                posicionActual++;
                continue;
            }
            catch(Exception q) {
                numero = Integer.MIN_VALUE;
            }

            if (caracterActual == '(') {
                conteoParentesis++;
                posicionActual++;
                continue;
            }

            if (caracterActual == ')') {
                conteoParentesis--;
                posicionActual++;
                continue;
            }

            Operador posibleOperadorPrincipal = null;
            try {
                posibleOperadorPrincipal = new Operador(String.valueOf(caracterActual));
                if (conteoParentesis == 0) {

                    // 0.  Crear el NODO
                    Contenedor<ElementoAritmetico> resultadoNodo =
                            new Contenedor<ElementoAritmetico>(posibleOperadorPrincipal);
                    resultadoNodo.setPadre(padre);

                    // 1. Crear el NODO IZQUIERDA
                    String izquierdaExpresion = expresion.substring(0, posicionActual);
                    Contenedor<ElementoAritmetico> izquierdaNodo = leerExpresion(resultadoNodo, izquierdaExpresion);
                    resultadoNodo.getHijos().add(izquierdaNodo);

                    // 2. Crear el NODO DERECHA
                    String derechaExpresion = expresion.substring(posicionActual+1);
                    Contenedor<ElementoAritmetico> derechaNodo = leerExpresion(resultadoNodo, derechaExpresion);
                    resultadoNodo.getHijos().add(derechaNodo);

                    return resultadoNodo;
                }
                else {
                    posicionActual++;
                    continue;
                }
            } catch(Exception q) {
                posicionActual++;
                continue;
            }
        }

        if (expresion.startsWith("(") && expresion.endsWith(")") && conteoParentesis == 0)
            return leerExpresion(padre, expresion.substring(1, expresion.length() - 1));

        throw new Exception("No pudo leer la expresion");
    }

    public double evaluar(){
        if(raiz == null)
            return Double.MIN_VALUE;
        return evaluarContenedor(raiz);
    }

    public double evaluarContenedor(Contenedor<ElementoAritmetico> nodo) {
        if(nodo == null)
            return Double.MIN_VALUE;

        ElementoAritmetico elementoAritmetico = nodo.getContenido();
        if(elementoAritmetico instanceof Numero){
            return ((Numero) elementoAritmetico).getValor();
        }

        Operador operacion = (Operador) elementoAritmetico;
        if(operacion.getNombre().equals("Suma")){
            return sumarHijos(nodo);
        }
        if(operacion.getNombre().equals("Resta")){
            return restarHijos(nodo);
        }
        if(operacion.getNombre().equals("Multiplicacion")){
            return multiplicarHijos(nodo);
        }
        if(operacion.getNombre().equals("Division")){
            return dividirHijos(nodo);
        }
        if(operacion.getNombre().equals("Raiz")){
            return raizHijos(nodo);
        }
        if(operacion.getNombre().equals("Potencia")){
            return potenciaHijos(nodo);
        }
        return Double.MIN_VALUE;
    }

    private double dividirHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        boolean primero = true;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            double evaluarHijo = evaluarContenedor(hijo);
            if(primero){
                resultado += evaluarHijo;
                primero = false;
            } else {
                resultado /= evaluarHijo;
            }
        }
        return resultado;
    }

    private double multiplicarHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        boolean primero = true;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            double evaluarHijo = evaluarContenedor(hijo);
            if(primero){
                resultado += evaluarHijo;
                primero = false;
            } else {
                resultado *= evaluarHijo;
            }
        }
        return resultado;
    }

    private double restarHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        boolean primero = true;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            double evaluarHijo = evaluarContenedor(hijo);
            if(primero){
                resultado += evaluarHijo;
                primero = false;
            } else {
                resultado -= evaluarHijo;
            }
        }
        return resultado;
    }

    private double sumarHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            double evaluarHijo = evaluarContenedor(hijo);
            resultado += evaluarHijo;
        }
        return resultado;
    }

    private double raizHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        boolean primero = true;
        double primeroNumero = 0;
        double segundoNumero = 0;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            double evaluarHijo = evaluarContenedor(hijo);
            if(primero){
                primeroNumero = evaluarHijo;
                primero = false;
            } else {
                segundoNumero = evaluarHijo;
                resultado = Math.pow(segundoNumero, 1/primeroNumero);
            }
        }
        return resultado;
    }

    private double potenciaHijos(Contenedor<ElementoAritmetico> nodo) {
        double resultado = 0;
        boolean primero = true;
        double primeroNumero = 0;
        double segundoNumero = 0;
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            double evaluarHijo = evaluarContenedor(hijo);
            if(primero){
                primeroNumero = evaluarHijo;
                primero = false;
            } else {
                segundoNumero = evaluarHijo;
                resultado = Math.pow(primeroNumero, segundoNumero);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return toStringAritmetico(raiz) + " = " + String.valueOf(evaluar());
    }

    public String toStringAritmetico(Contenedor<ElementoAritmetico> nodo) {
        ElementoAritmetico elementoAritmetico = nodo.getContenido();
        if(elementoAritmetico instanceof Numero){
            return String.valueOf(((Numero) elementoAritmetico).getValor());
        }

        Operador operacion = (Operador) elementoAritmetico;
        String operacionString = operacion.getSimbolo();

        StringBuilder resultado = new StringBuilder();
        resultado.append("(");
        String separador = "";
        for (Contenedor<ElementoAritmetico> hijo : nodo.getHijos()){
            String hijoString = toStringAritmetico(hijo);
            resultado.append(separador).append(hijoString);
            separador = operacionString;
        }
        resultado.append(")");
        return resultado.toString();
    }
}
