package Programacion4.Practico12;

import java.util.Objects;

import Programacion4.Practico11.diccionario.Comparador;

public class ComparadorVehiculo implements Comparador<Automovil> {

    @Override
    public boolean esIgual(Automovil key1, Automovil key2) {
        if (key1 == key2) {
            return true;
        }

        if (key1 == null || key2 == null)
            return false;

        return Objects.equals(key1.getMatricula(), key2.getMatricula());
    }

    @Override
    public int getHashCode(Automovil key) {
        return Objects.hash(key.getMatricula());
    }
}
