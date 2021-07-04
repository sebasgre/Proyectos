package SQL.BD1.Proyecto.dto;

public class DTOestadios {
    private String nombreEstadio;
    private String centroDeportivo;

    public DTOestadios(String nombreEstadio, String centroDeportivo) {
        this.nombreEstadio = nombreEstadio;
        this.centroDeportivo = centroDeportivo;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getCentroDeportivo() {
        return centroDeportivo;
    }

    public void setCentroDeportivo(String centroDeportivo) {
        this.centroDeportivo = centroDeportivo;
    }

}
