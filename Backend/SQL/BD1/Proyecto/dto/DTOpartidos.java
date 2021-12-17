package SQL.BD1.Proyecto.dto;

import java.sql.Date;

public class DTOpartidos {
    private int numPartido;
    private Date f_partido;
    private int equiposVisitantes_id;
    private int equiposLocales_id;
    private String estadios_id;

    public DTOpartidos(int numPartido, Date f_partido, int equiposVisitantes_id, int equiposLocales_id,
            String estadios_id) {
        this.numPartido = numPartido;
        this.f_partido = f_partido;
        this.equiposVisitantes_id = equiposVisitantes_id;
        this.equiposLocales_id = equiposLocales_id;
        this.estadios_id = estadios_id;
    }

    public int getNumPartido() {
        return numPartido;
    }

    public void setNumPartido(int numPartido) {
        this.numPartido = numPartido;
    }

    public Date getF_partido() {
        return f_partido;
    }

    public void setF_partido(Date f_partido) {
        this.f_partido = f_partido;
    }

    public int getEquiposVisitantes_id() {
        return equiposVisitantes_id;
    }

    public void setEquiposVisitantes_id(int equiposVisitantes_id) {
        this.equiposVisitantes_id = equiposVisitantes_id;
    }

    public int getEquiposLocales_id() {
        return equiposLocales_id;
    }

    public void setEquiposLocales_id(int equiposLocales_id) {
        this.equiposLocales_id = equiposLocales_id;
    }

    public String getEstadios_id() {
        return estadios_id;
    }

    public void setEstadios_id(String estadios_id) {
        this.estadios_id = estadios_id;
    }

}
