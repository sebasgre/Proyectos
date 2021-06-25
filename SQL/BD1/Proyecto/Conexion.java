package SQL.BD1.Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    // Nombre de la base de datos
    private String database = "proyecto";

    // Host
    private String hostname = "localhost"; // 127.0.0.1 == localhost

    // Puerto
    private String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con
    // "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    // jdbc:mysql://127.0.0.1:3306/empresa

    // Nombre de usuario
    private String username = "root";

    // Clave de usuario
    private String password = "root";

    private Connection conn;

    public Connection conectarMySQL() {
        conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexion MySQL-Java exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void ejecutarSQL(String sql) {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void obtenerSQL(String sql) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ".- " + rs.getString(2));
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
