package SQL.BD1.Proyecto.dto;

public class DTOequipos {
    private int codigo;
    private String nombre;
    private String pais;
    private int presidente_id;
    private int directoresTecnicos_id;

    public DTOequipos(int codigo, String nombre, String pais, int presidente_id, int directoresTecnicos_id) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
        this.presidente_id = presidente_id;
        this.directoresTecnicos_id = directoresTecnicos_id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getPresidente_id() {
        return presidente_id;
    }

    public void setPresidente_id(int presidente_id) {
        this.presidente_id = presidente_id;
    }

    public int getDirectoresTecnicos_id() {
        return directoresTecnicos_id;
    }

    public void setDirectoresTecnicos_id(int directoresTecnicos_id) {
        this.directoresTecnicos_id = directoresTecnicos_id;
    }

}
