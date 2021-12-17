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
    }
