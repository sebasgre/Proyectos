package SQL.BD1.Proyecto;


public class Consola {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectarMySQL();
        con.obtenerSQL("SELECT * FROM directoresAdmins");
    }
}
