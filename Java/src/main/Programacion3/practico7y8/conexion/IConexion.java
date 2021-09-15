package Programacion3.practico7y8.conexion;

import java.sql.ResultSet;

public interface IConexion {

    public ResultSet ejecutarConsulta(String query) throws Exception; //Select

    public void ejecutarComando(String query) throws Exception;//Insert,Update, Delete

    public void cerrarConexion();
}
