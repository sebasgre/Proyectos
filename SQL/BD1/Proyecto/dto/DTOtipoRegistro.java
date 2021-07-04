package SQL.BD1.Proyecto.dto;

public class DTOtipoRegistro {
    private int jugadores_id;
    private int partidos_id;
    private String posicion;
    private int numGoles;
    private int numAsistencias;
    private int minutoIncidente;
    private String tipoTarjeta;
    private int minutosJugados;

    public DTOtipoRegistro(int jugadores_id, int partidos_id, String posicion, int numGoles, int numAsistencias,
            int minutoIncidente, String tipoTarjeta, int minutosJugados) {
        this.jugadores_id = jugadores_id;
        this.partidos_id = partidos_id;
        this.posicion = posicion;
        this.numGoles = numGoles;
        this.numAsistencias = numAsistencias;
        this.minutoIncidente = minutoIncidente;
        this.tipoTarjeta = tipoTarjeta;
        this.minutosJugados = minutosJugados;
    }

    public int getJugadores_id() {
        return jugadores_id;
    }

    public void setJugadores_id(int jugadores_id) {
        this.jugadores_id = jugadores_id;
    }

    public int getPartidos_id() {
        return partidos_id;
    }

    public void setPartidos_id(int partidos_id) {
        this.partidos_id = partidos_id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    public int getNumAsistencias() {
        return numAsistencias;
    }

    public void setNumAsistencias(int numAsistencias) {
        this.numAsistencias = numAsistencias;
    }

    public int getMinutoIncidente() {
        return minutoIncidente;
    }

    public void setMinutoIncidente(int minutoIncidente) {
        this.minutoIncidente = minutoIncidente;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }
}
