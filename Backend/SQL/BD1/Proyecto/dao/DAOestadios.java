package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.demo.src.main.java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOestadios;

public class DAOestadios {
    public Lista2<DTOestadios> getTodos() {
        Lista2<DTOestadios> resultado = null;
        String query = "select nombreEstadio, centroDeportivo from estadios";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOestadios>();
            while (rs.next()) {
                String _nombreEstadio = rs.getString("nombreEstadio");
                String _centroDeportivo = rs.getString("centroDeportivo");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOestadios(_nombreEstadio, _centroDeportivo));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOestadios getPorId(String id) {
        DTOestadios resultado = null;
        String query = "select nombreEstadio, centroDeportivo from estadios where nombreEstadio = " + id;

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
                String _nombreEstadio = rs.getString("nombreEstadio");
                String _centroDeportivo = rs.getString("centroDeportivo");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOestadios(_nombreEstadio, _centroDeportivo);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOestadios p) {

        String query = "update estadios set centroDeportivo = '" + p.getCentroDeportivo() + "' where centroDeportivo = '" + p.getCentroDeportivo() +  "'";
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOestadios p) {

        String query = "insert into estadios (nombreEstadio, centroDeportivo) values ('" + p.getNombreEstadio()
                + "','" + p.getCentroDeportivo() + "')";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOestadios p) {

        String query = "delete from estadios where centroDeportivo = '" + p.getCentroDeportivo() + "'";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
