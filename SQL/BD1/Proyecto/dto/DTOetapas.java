package SQL.BD1.Proyecto.dto;

public class DTOetapas {
    private int numEtapa;
    private String nombreEtapa;
    private int directoresAdmins_id;

    public DTOetapas(int numEtapa, String nombreEtapa, int directoresAdmins_id) {
        this.numEtapa = numEtapa;
        this.nombreEtapa = nombreEtapa;
        this.directoresAdmins_id = directoresAdmins_id;
    }

    public int getNumEtapa() {
        return numEtapa;
    }

    public void setNumEtapa(int numEtapa) {
        this.numEtapa = numEtapa;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public int getDirectoresAdmins_id() {
        return directoresAdmins_id;
    }

    public void setDirectoresAdmins_id(int directoresAdmins_id) {
        this.directoresAdmins_id = directoresAdmins_id;
    }

}
