package Programacion3.practico7y8.conexion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ConexionMySql extends Conexion{
    private final static Logger logger = LogManager.getLogger();

    private String host;
    private String database;
    private int port;
    private String username;

    private String password;
    private String url;
    private String urlcredentials;
    private Connection conn;

    public ConexionMySql(){
        host = "localhost";
        database = "practico8";
        port = 3306;
        username = "root";
        password = "root";
        url = "jdbc:mysql://" + host + ":" + port + "/" + database/* + "?useSSL=false"*/;
        urlcredentials = url + "?user=" + username + "&password=" + password;
        try {
            conn = DriverManager.getConnection(urlcredentials);
            /*
            DriverManager pregunta entre las clases que tiene a disposicion,  en el servidor
            le va preguntar si no hay alguna que entiene la url, si las hay da una instancia
            de una connection
             */
        } catch (SQLException e) {
            System.out.println("No puede conetarse al servidor");
            logger.info("No pudo conectarse al servidor");
        }
    }

    @Override
    public ResultSet ejecutarConsulta(String query) throws Exception {
        ResultSet res = null;
        // JDBC se inventa una cuestion que se llama ResultSet es lo mas parecido a un iterador
        Statement stmt = conn.createStatement();
        //Statement es una consulta
        //conn.createStatement() agarra y a la conexion le dice voy a crearme una consulta
        res = stmt.executeQuery(query);
        /*
            stmt sobre ese objeto consulta voy a ejecutar esta consulta en especifico query
            y eso me da un iterador, sobre cada uno de los resultados que encuentre.
             */
        return res;
    }

    @Override
    public void ejecutarComando(String query) throws Exception {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    @Override
    public void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
