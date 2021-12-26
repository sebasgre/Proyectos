package Programacion4.Practico11.diccionario;

import java.util.Objects;

public class ComparadorGenerico<TKEY> implements Comparador<TKEY> {

    @Override
    public boolean esIgual(TKEY key1, TKEY key2) {
        return Objects.equals(key1, key2);
    }

    @Override
    public int getHashCode(TKEY key) {
        return Objects.hash(key);
    }
}
