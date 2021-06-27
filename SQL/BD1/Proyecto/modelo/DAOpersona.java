package SQL.BD1.Proyecto.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;

public class DAOpersona {
	
	public DAOpersona() {
	}
	
	public Lista2<DTOpersona> getTodos() {
		Lista2<DTOpersona> resultado = null;
		String query = "select id, nombre from persona";
		
		ResultSet rs = null;
		try {
			DSConexion conexion = DSConexion.getOrCreate(); 
			rs = conexion.ejecutarConsulta(query);
		} catch (SQLException e) {
			System.out.println("No pudo ejecutar consulta");
			return resultado;
		}
		
		try {
			resultado = new Lista2<DTOpersona>();
			while (rs.next()) {
				int _id = rs.getInt("id");
				String _nombre = rs.getString("nombre");
				resultado.insertar(new DTOpersona(_id, _nombre));
			}
		} catch (SQLException e) {
			System.out.println("Error recuperando datos del resultset: " + e.getMessage());
		}
		
		return resultado;
	}
	
	public DTOpersona getPorId(int id) {
		DTOpersona resultado = null;
		String query = "select id, nombre from persona where id=" + id;

		ResultSet rs = null;
		try {
			DSConexion conexion = DSConexion.getOrCreate();
			rs = conexion.ejecutarConsulta(query);
		} catch (SQLException e) {
			System.out.println("No pudo ejecutar consulta");
			return resultado;
		}
		
		try {
			if (rs.next()) {
				int _id = rs.getInt("id");
				String _nombre = rs.getString("nombre");
				resultado = new DTOpersona(_id, _nombre);
			}
		} catch (SQLException e) {
			System.out.println("Error recuperando datos del resultset: " + e.getMessage());
		}
		
		return resultado;
	}
	
	public void actualizar(DTOpersona p) {
		String query = "update persona set nombre='" + p.getNombre() + "' where id="+ p.getId();

		try {
			DSConexion conexion = DSConexion.getOrCreate();
			conexion.ejecutarComando(query);
		} catch (SQLException e) {
			System.out.println("No pudo ejecutar consulta");
		}
	}
	
	public void insertar(DTOpersona p) {
		String query = "insert into persona (id,nombre) values ("+ p.getId() + ",'" + p.getNombre() + "')";

		try {
			DSConexion conexion = DSConexion.getOrCreate();
			conexion.ejecutarComando(query);
		} catch (SQLException e) {
			System.out.println("No pudo ejecutar consulta");
		}
	}
	
	public void eliminar(DTOpersona p) {
		String query = "delete from persona where id=" + p.getId();

		try {
			DSConexion conexion = DSConexion.getOrCreate();
			conexion.ejecutarComando(query);
		} catch (SQLException e) {
			System.out.println("No pudo ejecutar consulta");
		}
	}
}
