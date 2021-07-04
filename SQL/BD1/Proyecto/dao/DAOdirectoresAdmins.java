package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOarbitros;
import SQL.BD1.Proyecto.dto.DTOdirectoresAdmins;

public class DAOdirectoresAdmins {
    // private DSConexion conexion;

    // patron dao para acceder a la base de datos
    public Lista2<DTOdirectoresAdmins> getTodos() {
        Lista2<DTOdirectoresAdmins> resultado = null;
        String query = "select dni, nombre from directoresAdmins";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOdirectoresAdmins>();
            while (rs.next()) {
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOdirectoresAdmins(_dni, _nombre));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOdirectoresAdmins getPorId(int id) {
        DTOdirectoresAdmins resultado = null;
        String query = "select dni, nombre from directoresAdmins where dni = " + id;

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
                resultado = new DTOdirectoresAdmins(_dni, _nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOdirectoresAdmins p) {

        String query = "update arbitros set nombre = '" + p.getNombre() + "' where dni = " + p.getDni();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOarbitros p) {

        String query = "insert into directoresAdmins (dni, nombre) values (" + p.getDni() + ",'" + p.getNombre() + "')";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOdirectoresAdmins p) {

        String query = "delete from directoresAdmins where dni = " + p.getDni();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}