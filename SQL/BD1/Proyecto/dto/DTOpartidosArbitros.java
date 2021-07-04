package SQL.BD1.Proyecto.dto;

public class DTOpartidosArbitros {
    private int partidos_id;
    private int arbitros_id;
    private String rolPartido;

    public DTOpartidosArbitros(int partidos_id, int arbitros_id, String rolPartido) {
        this.partidos_id = partidos_id;
        this.arbitros_id = arbitros_id;
        this.rolPartido = rolPartido;
    }

    public int getPartidos_id() {
        return partidos_id;
    }

    public void setPartidos_id(int partidos_id) {
        this.partidos_id = partidos_id;
    }

    public int getArbitros_id() {
        return arbitros_id;
    }

    public void setArbitros_id(int arbitros_id) {
        this.arbitros_id = arbitros_id;
    }

    public String getRolPartido() {
        return rolPartido;
    }

    public void setRolPartido(String rolPartido) {
        this.rolPartido = rolPartido;
    }

}
