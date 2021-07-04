package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOpresidentes;

public class DAOpresidentes {
    public Lista2<DTOpresidentes> getTodos() {
        Lista2<DTOpresidentes> resultado = null;
        String query = "select dni, nombre from presidentes";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOpresidentes>();
            while (rs.next()) {
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOpresidentes(_dni, _nombre));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOpresidentes getPorId(int id) {
        DTOpresidentes resultado = null;
        String query = "select dni, nombre from presidentes where dni = " + id;

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
                resultado = new DTOpresidentes (_dni, _nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOpresidentes p) {

        String query = "update presidentes set nombre = '" + p.getNombre() + "' where dni = " + p.getDni();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOpresidentes p) {

        String query = "insert into jugadores (dni, nombre, sueldo, sexo, numDorsal, equipos_id) values (" + p.getDni()
                + ",'" + p.getNombre() + ")";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOpresidentes p) {

        String query = "delete from presidentes where dni = " + p.getDni();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
