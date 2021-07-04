package SQL.BD1.Proyecto.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOpartidos;

public class DAOpartidos {
    // private DSConexion conexion;

    // patron dao para acceder a la base de datos
    public Lista2<DTOpartidos> getTodos() {
        Lista2<DTOpartidos> resultado = null;
        String query = "select numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id from partidos";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOpartidos>();
            while (rs.next()) {
                int numPartido = rs.getInt("numPartido");
                Date f_partido = rs.getDate("f_partido");
                int equiposVisitantes_id = rs.getInt("equiposVisitantes_id");
                int equiposLocales_id = rs.getInt("equiposLocales_id");
                String estadios_id = rs.getString("estadios_id");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(
                        new DTOpartidos(numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOpartidos getPorId(int id) {
        DTOpartidos resultado = null;
        String query = "select numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id from partidos where numPartido = "
                + id;

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
                int numPartido = rs.getInt("numPartido");
                Date f_partido = rs.getDate("f_partido");
                int equiposVisitantes_id = rs.getInt("equiposVisitantes_id");
                int equiposLocales_id = rs.getInt("equiposLocales_id");
                String estadios_id = rs.getString("estadios_id");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOpartidos(numPartido, f_partido, equiposVisitantes_id, equiposLocales_id,
                        estadios_id);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    /*
     * public void actualizar(DTOpartidos p){
     * 
     * String query = "update partidos set nombre = '" + p.getNombre() +
     * "' where dni = " + p.getDni(); try { DSConexion conexion =
     * DSConexion.getOrCreate(); conexion.ejecutarComando(query); } catch
     * (SQLException e) { System.out.println("No pudo ejecutar consulta"); } }
     */

    public void insertar(DTOpartidos p) {

        String query = "insert into partidos (numPartido, f_partido, equiposVisitantes_id, equiposLocales_id, estadios_id) values ("
                + p.getNumPartido() + ",'" + p.getF_partido() + "'," + p.getEquiposVisitantes_id() + ","
                + p.getEquiposLocales_id() + ",'" + p.getEstadios_id() + "')";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOpartidos p) {

        String query = "delete from partidos where numPartido = " + p.getNumPartido();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
