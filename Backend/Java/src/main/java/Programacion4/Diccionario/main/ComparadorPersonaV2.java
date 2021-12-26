package Programacion4.Diccionario.main;

import java.util.Objects;

import Programacion4.Diccionario.diccionario.Comparador;

public class ComparadorPersonaV2 implements Comparador<Persona> {

    @Override
    public boolean esIgual(Persona key1, Persona key2) {
        if(key1 == key2){
            return true;
        }

        if(key1 == null || key2 == null)
            return false;

        return Objects.equals(key1.getCi().toLowerCase(), key2.getCi().toLowerCase()) &&
                Objects.equals(key1.getNombre().toLowerCase(), key2.getNombre().toLowerCase());
    }

    @Override
    public int getHashCode(Persona key) {
        return Objects.hash(key.getCi(), key.getNombre());
    }
}