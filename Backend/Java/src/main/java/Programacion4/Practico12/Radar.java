package Programacion4.Practico12;


import java.util.ArrayList;
import java.util.List;

import Programacion4.Practico11.diccionario.DiccionarioTablaHash;


public class Radar {
    private DiccionarioTablaHash<Automovil, List<Automovil>> registro;

    public Radar() {
        registro = new DiccionarioTablaHash<>(new ComparadorVehiculo());
    }

    public void registrar(Automovil auto) {
        List<Automovil> lista = null;
        if (registro.contineLlave(auto)) {
            lista = registro.obtener(auto);
        } else {
            lista = new ArrayList<>();
            registro.insertar(auto, lista);
        }
        lista.add(auto);
    }



    public EstadisticaRadar getEstadistica(Automovil auto) {
        EstadisticaRadar radar = null;
        if (registro.contineLlave(auto)) {
            double velocidad = 0;
            int veces = 0;
            for (Automovil au : registro.obtener(auto)) {
                velocidad += au.getVelocidad();
                veces++;
            }
            radar = new EstadisticaRadar(velocidad / veces, veces);
        } else {
            radar = new EstadisticaRadar(0, 0);
        }
        return radar;
    }
}
