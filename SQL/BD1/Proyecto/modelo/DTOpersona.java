package SQL.BD1.Proyecto.modelo;

public class DTOpersona {

	private int id;
	private String nombre;
	
	public DTOpersona(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Persona: id = " + id + " | nombre = " + nombre;
	}
}