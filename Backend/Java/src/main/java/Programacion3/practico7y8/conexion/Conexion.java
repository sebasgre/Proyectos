package Programacion3.practico7y8.conexion;

public abstract class Conexion implements IConexion{

    private static Conexion unicaConexion = null;

    public static Conexion getOrCreate() {
        if (unicaConexion == null)
            // Aqui el unico lugar donde se cambia la conexion
            unicaConexion = new ConexionMySql();
        return unicaConexion;
    }
}
