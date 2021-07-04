package SQL.BD1.Proyecto.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOclasifican;

public class DAOclasifican {
    // private DSConexion conexion;

    // patron dao para acceder a la base de datos
    public Lista2<DTOclasifican> getTodos() {
        Lista2<DTOclasifican> resultado = null;
        String query = "select equipos_id, etapas_id, fecha from clasifican";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOclasifican>();
            while (rs.next()) {
                int equipos_id = rs.getInt("equipos_id");
                int etapas_id = rs.getInt("etapas_id");
                Date fecha = rs.getDate("fecha");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOclasifican(equipos_id, etapas_id, fecha));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOclasifican getPorId(int id) {
        DTOclasifican resultado = null;
        String query = "select equipos_id, etapas_id, fecha from clasifican where equipos_id = " + id;

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
                int equipos_id = rs.getInt("equipos_id");
                int etapas_id = rs.getInt("etapas_id");
                Date fecha = rs.getDate("fecha");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOclasifican(equipos_id, etapas_id, fecha);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    /*
     * public void actualizar(DTOclasifican p){
     * 
     * String query = "update clasifican set equipos_id = '" + p.getEquipos_id() +
     * "' where dni = " + p.getDni(); try { DSConexion conexion =
     * DSConexion.getOrCreate(); conexion.ejecutarComando(query); } catch
     * (SQLException e) { System.out.println("No pudo ejecutar consulta"); } }
     */

    public void insertar(DTOclasifican p) {

        String query = "insert into clasifican (equipos_id, etapas_id, fecha) values (" + p.getEquipos_id() + ","
                + p.getEtapas_id() + ",'" + p.getFecha() + "')";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
/*
 * public void eliminar(DTOclasifican p){
 * 
 * String query = "delete from directoresAdmins where dni = " + p.getDni();
 * 
 * try { DSConexion conexion = DSConexion.getOrCreate();
 * conexion.ejecutarComando(query); } catch (SQLException e) {
 * System.out.println("No pudo ejecutar consulta"); } } }
 */