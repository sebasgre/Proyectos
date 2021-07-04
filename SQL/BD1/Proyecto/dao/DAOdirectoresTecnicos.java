package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOdirectoresTecnicos;

public class DAOdirectoresTecnicos {
    // private DSConexion conexion;

    // patron dao para acceder a la base de datos
    public Lista2<DTOdirectoresTecnicos> getTodos() {
        Lista2<DTOdirectoresTecnicos> resultado = null;
        String query = "select dni, nombre from directoresTecnicos";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOdirectoresTecnicos>();
            while (rs.next()) {
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOdirectoresTecnicos(_dni, _nombre));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOdirectoresTecnicos getPorId(int id) {
        DTOdirectoresTecnicos resultado = null;
        String query = "select dni, nombre from directoresTecnicos where dni = " + id;

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
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOdirectoresTecnicos(_dni, _nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOdirectoresTecnicos p) {

        String query = "update directoresTecnicos set nombre = '" + p.getNombre() + "' where dni = " + p.getDni();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOdirectoresTecnicos p) {

        String query = "insert into directoresTecnicos (dni, nombre) values (" + p.getDni() + ",'" + p.getNombre() + "')";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOdirectoresTecnicos p) {

        String query = "delete from directoresTecnicos where dni = " + p.getDni();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}