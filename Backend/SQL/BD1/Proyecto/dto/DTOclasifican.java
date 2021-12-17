package SQL.BD1.Proyecto.dto;

import java.sql.Date;

public class DTOclasifican {
    private int equipos_id;
    private int etapas_id;
    private Date fecha;

    public DTOclasifican(int equipos_id, int etapas_id, Date fecha) {
        this.equipos_id = equipos_id;
        this.etapas_id = etapas_id;
        this.fecha = fecha;
    }

    public int getEquipos_id() {
        return equipos_id;
    }

    public void setEquipos_id(int equipos_id) {
        this.equipos_id = equipos_id;
    }

    public int getEtapas_id() {
        return etapas_id;
    }

    public void setEtapas_id(int etapas_id) {
        this.etapas_id = etapas_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
