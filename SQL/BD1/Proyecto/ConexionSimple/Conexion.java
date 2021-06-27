package SQL.BD1.Proyecto.ConexionSimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
    private final static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        String host = "localhost";
        String database = "proyecto";
        int port = 5432;
        String username = "root";

        String password = "root"; // colocar la contraseña
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        String urlcredentials = url + "?user=" + username + "&password=" + password;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urlcredentials);
        } catch (SQLException e) {
            logger.error("No pudo conectarse a la base de datos", e);
            System.exit(0);
        }
        String query = "SELECT id, nombre FROM persona";
        ResultSet res = null;
        try {
            Statement stmt = conn.createStatement();
            res = stmt.executeQuery(query);
        } catch (SQLException e) {
            logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
        try {
            while (res.next()) {
                int _id = res.getInt("id");
                String _nombre = res.getString("nombre");
                System.out.println("(" + _id + ") '" + _nombre + "'");
            }
            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);
        }
    }
    /*
     * // Nombre de la base de datos private String database = "proyecto";
     * 
     * // Host private String hostname = "localhost"; // 127.0.0.1 == localhost
     * 
     * // Puerto private String port = "3306";
     * 
     * // Ruta de nuestra base de datos (desactivamos el uso de SSL con //
     * "?useSSL=false") private String url = "jdbc:mysql://" + hostname + ":" + port
     * + "/" + database + "?useSSL=false"; // jdbc:mysql://127.0.0.1:3306/empresa
     * 
     * // Nombre de usuario private String username = "root";
     * 
     * // Clave de usuario private String password = "root";
     * 
     * private Connection conn;
     * 
     * public Connection conectarMySQL() { conn = null;
     * 
     * try { Class.forName("com.mysql.cj.jdbc.Driver"); conn =
     * DriverManager.getConnection(url, username, password);
     * System.out.println("Conexion MySQL-Java exitosa"); } catch
     * (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
     * 
     * return conn; }
     * 
     * public void ejecutarSQL(String sql) { try { Statement st =
     * conn.createStatement(); st.executeUpdate(sql); st.close(); } catch
     * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
     * }
     * 
     * public void obtenerSQL(String sql) { try { Statement st =
     * conn.createStatement(); ResultSet rs = st.executeQuery(sql); while
     * (rs.next()) { System.out.println(rs.getInt(1) + ".- " + rs.getString(2)); }
     * rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
     * e.printStackTrace(); } }
     */
}
