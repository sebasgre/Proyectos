package Java.demo.src.main.java.Programacion3.Practico4.Lista;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java.demo.src.main.java.Programacion3.Practico4.Modelo.Persona;

public class ComparadorPersona implements Comparator<Persona> {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Persona o1, Persona o2) {
        if (o2.getAltura() == o1.getAltura())
            return 0;

        if (o2.getAltura() < o1.getAltura())
            return -1;

        if (o2.getAltura() > o1.getAltura())
            return 1;
        logger.debug("Aqui comparamos actual con siguiente para hacer el ordenamiento");
        return o2.getNombre().compareTo(o1.getNombre());
    }
}
