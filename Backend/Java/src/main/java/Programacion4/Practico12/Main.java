package Programacion4.Practico12;

public class Main {
    public static void main(String[] args) {
        Radar radar = new Radar();
        radar.registrar(new Automovil("ABC-123", 68.6));
        radar.registrar(new Automovil("ABC-123", 80.3));
        radar.registrar(new Automovil("XYZ-789", 55.3));
        radar.registrar(new Automovil("ABC-123", 68.6));
        radar.registrar(new Automovil("XYZ-789", 45));
        radar.registrar(new Automovil("XYZ-789", 38.9));
        radar.registrar(new Automovil("XYZ-789", 88.2));
        System.out.println(radar.getEstadistica(new Automovil("ABC-123")));
        System.out.println(radar.getEstadistica(new Automovil("BFC-581")));
        System.out.println(radar.getEstadistica(new Automovil("XYZ-789")));
    }
}
