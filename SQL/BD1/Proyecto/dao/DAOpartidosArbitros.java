package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOpartidosArbitros;

public class DAOpartidosArbitros {
    // private DSConexion conexion;

    // patron dao para acceder a la base de datos
    public Lista2<DTOpartidosArbitros> getTodos() {
        Lista2<DTOpartidosArbitros> resultado = null;
        String query = "select partidos_id, arbitros_id, rolPartido from partidosarbitros";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOpartidosArbitros>();
            while (rs.next()) {
                int partido_id = rs.getInt("partidos_id");
                int arbitros_id = rs.getInt("arbitros_id");
                String rolPartido = rs.getString("rolPartido");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOpartidosArbitros(partido_id, arbitros_id, rolPartido));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOpartidosArbitros getPorId(int id) {
        DTOpartidosArbitros resultado = null;
        String query = "select partidos_id, arbitros_id, rolPartido from partidosarbitros where partidos_id = " + id;

        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            if (rs.next()) {
                int partido_id = rs.getInt("partidos_id");
                int arbitros_id = rs.getInt("arbitros_id");
                String rolPartido = rs.getString("rolPartido");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOpartidosArbitros(partido_id, arbitros_id, rolPartido);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    /*
     * public void actualizar(DTOpartidosArbitros p){
     * 
     * String query = "update partidos set nombre = '" + p.getNombre() +
     * "' where dni = " + p.getDni(); try { DSConexion conexion =
     * DSConexion.getOrCreate(); conexion.ejecutarComando(query); } catch
     * (SQLException e) { System.out.println("No pudo ejecutar consulta"); } }
     */

    public void insertar(DTOpartidosArbitros p) {

        String query = "insert into partidosarbitros (partidos_id, arbitros_id, rolPartido) values ("
                + p.getPartidos_id() + "," + p.getArbitros_id() + ",'" + p.getRolPartido() + "')";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    /*
     * public void eliminar(DTOpartidosArbitros p){
     * 
     * String query = "delete from partidosArbitros where numPartido = " +
     * p.getNumPartido();
     * 
     * try { DSConexion conexion = DSConexion.getOrCreate();
     * conexion.ejecutarComando(query); } catch (SQLException e) {
     * System.out.println("No pudo ejecutar consulta"); } }
     */
}
