package SQL.BD1.Proyecto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DSConexion {
	private String host = "localhost";
	private String database = "edd-ejemplo";
	private int port = 5432;
	private String username = "postgres";

	private String password = "postgres"; // colocar la contraseña
	private String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
	private String urlcredentials = url + "?user=" + username + "&password=" + password;
	private Connection conn = null;

	private static DSConexion unicaConexion = null;
	
	public static DSConexion getOrCreate() {
		if (unicaConexion == null)
			unicaConexion = new DSConexion();
		return unicaConexion;
	}
	
	private DSConexion() {
		try {
			conn = DriverManager.getConnection(urlcredentials);
		} catch (SQLException e) {
			System.out.println("No puede conectarse al servidor");
		}
	}

	public ResultSet ejecutarConsulta(String query) throws SQLException {
		ResultSet res = null;
		Statement stmt = conn.createStatement();
		res = stmt.executeQuery(query);
		return res;
	}

	public void ejecutarComando(String query) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
	}
	
	public void cerrarConexion() throws SQLException {
		conn.close();
	}
}