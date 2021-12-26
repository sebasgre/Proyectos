package Programacion4.Pruebas;

public class CribaErastotenes {
    private boolean[] numeros;

    public CribaErastotenes(int size){
        numeros = new boolean[size];
        inicializar();
    }

    private void inicializar() {
        int size =  numeros.length;
        for (int i = 2;  i * i <= size ; i++) {

            if(numeros[i - 1] == true) {
                continue;
            }
            for(int j = i + i ; j <= size; j += i){

                numeros[j - 1] = true;
            }
        }
    }

    public boolean esPrimo(int nro){
        return !numeros[nro - 1];
    }
}
