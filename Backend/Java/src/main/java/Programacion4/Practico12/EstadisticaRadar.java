package Programacion4.Practico12;

public class EstadisticaRadar {
    private double velocidadPromedio;
    private int veces;

    public EstadisticaRadar(double velocidad, int veces) {
        this.velocidadPromedio = velocidad;
        this.veces = veces;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }

    public String toString() {
        return veces == 0 && velocidadPromedio == 0 ?
                "El automovil no ha sido registrado" :
                "velocidadPromedio=" + velocidadPromedio +
                        ", veces=" + veces;
    }
}
