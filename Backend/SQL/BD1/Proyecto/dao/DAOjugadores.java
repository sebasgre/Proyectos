package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.demo.src.main.java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOjugadores;

public class DAOjugadores {
    public Lista2<DTOjugadores> getTodos() {
        Lista2<DTOjugadores> resultado = null;
        String query = "select j.dni, j.nombre, j.sueldo, j.sexo, j.numDorsal, e.nombre as equipo from jugadores j join equipos e ON j.equipos_id = e.codigo";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOjugadores>();
            while (rs.next()) {
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                double _sueldo = rs.getDouble("sueldo");
                String _sexo = rs.getString("sexo");
                String _numDorsal = rs.getString("numDorsal");
                String _equipos_id = rs.getString("equipo");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOjugadores(_dni, _nombre, _sueldo, _sexo, _numDorsal, _equipos_id));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public Lista2<DTOjugadores> getPorEquipos(String equipo) {
        Lista2<DTOjugadores> resultado = null;
        String query = "select j.dni, j.nombre, j.sueldo, j.sexo, j.numDorsal, e.nombre as equipo from jugadores j join equipos e ON j.equipos_id = e.codigo where e.nombre = '"
                + equipo + "'";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOjugadores>();
            while (rs.next()) {
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                double _sueldo = rs.getDouble("sueldo");
                String _sexo = rs.getString("sexo");
                String _numDorsal = rs.getString("numDorsal");
                String _equipos_id = rs.getString("equipo");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOjugadores(_dni, _nombre, _sueldo, _sexo, _numDorsal, _equipos_id));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

}
