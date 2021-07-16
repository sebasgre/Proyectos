package Java.Programacion3.practico7y8.modelo;

public class Operador extends ElementoAritmetico {

    private String simbolo;
    private String nombre;

    public Operador(String simbolo){
        this.simbolo = simbolo;
        if(simbolo.equals("+")){
            nombre = "Suma";
        }
        if(simbolo.equals("-")){
            nombre = "Resta";
        }
        if(simbolo.equals("*")){
            nombre = "Multiplicacion";
        }
        if(simbolo.equals("/")){
            nombre = "Division";
        }
        if(simbolo.equals("√")){
            nombre = "Raiz";
        }
        if(simbolo.equals("^")){
            nombre = "Potencia";
        }
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

}
