package BD1.Logica;
public class Consola {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectarMySQL();
        con.ejecutarSQL("INSERT INTO departamentos VALUES (10,'Operaciones',null,null)");
        con.obtenerSQL("SELECT * FROM departamentos");

    }
}
