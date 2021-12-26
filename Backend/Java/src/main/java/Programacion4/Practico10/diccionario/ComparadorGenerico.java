package Programacion4.Practico10.diccionario;

import java.util.Objects;

public class ComparadorGenerico<TKEY> implements Comparador<TKEY> {

    @Override
    public boolean esIgual(TKEY key1, TKEY key2) {
        return Objects.equals(key1, key2);
    }
}
