package SQL.BD1.Proyecto.dal;
import java.sql.*;

public class DSConexion {
    //DataSource
    private String host;
    private String database;
    private int port;
    private String username;

    private String password;
    private String url;
    private String urlcredentials;
    private Connection conn;

    public static DSConexion unicaConexion = null;


    public static DSConexion getOrCreate(){
        if(unicaConexion == null)
            unicaConexion = new DSConexion();
        return unicaConexion;
        // patron singleton
    }

    private DSConexion() {
        host = "localhost";
        database = "proyecto";
        port = 3306;
        username = "root";
        password = "root";
        url = "jdbc:mysql://" + host + ":" + port + "/" + database/* + "?useSSL=false"*/;
        urlcredentials = url + "?user=" + username + "&password=" + password;
        try {
            conn = DriverManager.getConnection(urlcredentials);
            /*
            DriverManager pregunta entre las clases que tiene a disposicion en el servidor
            le va preguntar si no hay alguna que entiene la url, si las hay da una instancia
            de una connection
             */
        } catch (SQLException e) {
            System.out.println("No puede conetarse al servidor");
        }
    }

    public ResultSet ejecutarConsulta(String query) throws SQLException {
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


    public void ejecutarComando(String query) throws SQLException {
        //Seria uno de los update delete insert
        /*
        podriamos hacer que nos devuelva boolean si, si o no lo pudo
        ejecutar(boolean), o que me devuelva cuantas filas fueron cambiadas
        por culpa de este insert o update o delete (int), o que me diga cual
        es el valor del identificador del id del objeto que acabo de meter en la tabla
        en el caso que sea autoincrement
         */
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void cerrarConexion() throws SQLException {
        conn.close();
    }
}
