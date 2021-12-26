package Programacion4.Grafos.diccionario;

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
