package SQL.BD1.Proyecto.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOarbitros;

public class DAOarbitros {
    // private DSConexion conexion;

    // patron dao para acceder a la base de datos
    public Lista2<DTOarbitros> getTodos() {
        Lista2<DTOarbitros> resultado = null;
        String query = "select dni, nombre, sueldo, sexo, peso, f_nacimiento, altura from arbitros";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOarbitros>();
            while (rs.next()) {
                int _dni = rs.getInt("dni");
                String _nombre = rs.getString("nombre");
                double _sueldo = rs.getDouble("sueldo");
                String _sexo = rs.getString("sexo");
                int _peso = rs.getInt("peso");
                Date _f_nacimiento = rs.getDate("f_nacimiento");
                int _altura = rs.getInt("altura");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOarbitros(_dni, _nombre, _sueldo, _sexo, _peso, _f_nacimiento, _altura));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOarbitros getPorId(int id) {
        DTOarbitros resultado = null;
        String query = "select dni, nombre, sueldo, sexo, peso, f_nacimiento, altura from arbitros where dni = " + id;

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
                double _sueldo = rs.getDouble("sueldo");
                String _sexo = rs.getString("sexo");
                int _peso = rs.getInt("peso");
                Date _f_nacimiento = rs.getDate("f_nacimiento");
                int _altura = rs.getInt("altura");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOarbitros(_dni, _nombre, _sueldo, _sexo, _peso, _f_nacimiento, _altura);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOarbitros p) {

        String query = "update arbitros set nombre = '" + p.getNombre() + "' where dni = " + p.getDni();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOarbitros p) {

        String query = "insert into arbitros (dni, nombre, sueldo, sexo, peso, f_nacimiento, altura) values ("
                + p.getDni() + ",'" + p.getNombre() + "'," + p.getSueldo() + ",'" + p.getSexo() + "'," + p.getPeso()
                + ",'" + p.getF_nacimiento() + "'," + p.getAltura() + ")";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOarbitros p) {

        String query = "delete from arbitros where dni = " + p.getDni();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
