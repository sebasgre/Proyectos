package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOetapas;

public class DAOetapas {
    public Lista2<DTOetapas> getTodos() {
        Lista2<DTOetapas> resultado = null;
        String query = "select numEtapa, nombreEtapa, directoresAdmins_id  from etapas";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOetapas>();
            while (rs.next()) {
                int _numEtapa = rs.getInt("numEtapa");
                String _nombreEtapa = rs.getString("nombreEtapa");
                int _directoresAdmins_id = rs.getInt("directoresAdmins_id");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOetapas(_numEtapa, _nombreEtapa, _directoresAdmins_id));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOetapas getPorId(int id) {
        DTOetapas resultado = null;
        String query = "select numEtapa, nombreEtapa, directoresAdmins_id  from etapas where numEtapa = " + id;

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
                int _numEtapa = rs.getInt("numEtapa");
                String _nombreEtapa = rs.getString("nombreEtapa");
                int _directoresAdmins_id = rs.getInt("directoresAdmins_id");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOetapas(_numEtapa, _nombreEtapa, _directoresAdmins_id);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOetapas p) {

        String query = "update etapas set nombreEtapa = '" + p.getNombreEtapa() + "' where numEtapa = " + p.getNumEtapa();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOetapas p) {

        String query = "insert into etapas (numEtapa, nombreEtapa, directoresAdmins_id) values (" + p.getNumEtapa()
                + ",'" + p.getNombreEtapa() + "'," + p.getDirectoresAdmins_id() + ")";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOetapas p) {

        String query = "delete from etapas where numEtapa = " + p.getNumEtapa();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
