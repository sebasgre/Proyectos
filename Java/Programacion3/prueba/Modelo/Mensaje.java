package Java.Programacion3.prueba.Modelo;

import java.time.LocalDateTime;

public class Mensaje {
    String mensaje;
    String nombre;
    LocalDateTime dateTime;

    public Mensaje(String mensaje, String nombre,  LocalDateTime dateTime2) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.dateTime = dateTime2;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    

}
