package SQL.BD1.Proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOtipoRegistro;

public class DAOtipoRegistro {

    public Lista2<DTOtipoRegistro> getTodos() {
        Lista2<DTOtipoRegistro> resultado = null;
        String query = "select jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados from tiporegistro";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOtipoRegistro>();
            while (rs.next()) {
                int _jugadores_id = rs.getInt("jugadores_id");
                int _partidos_id = rs.getInt("partidos_id");
                String _posicion = rs.getString("posicion");
                int _numGoles = rs.getInt("numGoles");
                int _numAsistencias = rs.getInt("numAsistencias");
                int _minutoIncidente = rs.getInt("minutoIncidente");
                String _tipoTarjeta = rs.getString("tipoTarjeta");
                int _minutosJugados = rs.getInt("minutosJugados");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado.add(new DTOtipoRegistro(_jugadores_id, _partidos_id, _posicion, _numGoles, _numAsistencias,
                        _minutoIncidente, _tipoTarjeta, _minutosJugados));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOtipoRegistro getPorId(int id1) {
        DTOtipoRegistro resultado = null;
        String query = "select jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados from tiporegistro where jugadores_id = "
                + id1;

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
                int _jugadores_id = rs.getInt("jugadores_id");
                int _partidos_id = rs.getInt("partidos_id");
                String _posicion = rs.getString("posicion");
                int _numGoles = rs.getInt("numGoles");
                int _numAsistencias = rs.getInt("numAsistencias");
                int _minutoIncidente = rs.getInt("minutoIncidente");
                String _tipoTarjeta = rs.getString("tipoTarjeta");
                int _minutosJugados = rs.getInt("minutosJugados");
                // recuerpo el entero como entero del iterador y recupero un string de la
                // columna nombre
                resultado = new DTOtipoRegistro(_jugadores_id, _partidos_id, _posicion, _numGoles, _numAsistencias,
                        _minutoIncidente, _tipoTarjeta, _minutosJugados);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOtipoRegistro p) {

        String query = "update tiporegistro set numGoles = " + p.getNumGoles() + " where jugadores_id = "
                + p.getJugadores_id();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOtipoRegistro p) {

        String query = "insert into tiporegistro (jugadores_id, partidos_id, posicion, numGoles, numAsistencias, minutoIncidente, tipoTarjeta, minutosJugados) values ("
                + p.getJugadores_id() + "," + p.getPartidos_id() + ",'" + p.getPosicion() + "'," + p.getNumGoles() + ","
                + p.getNumAsistencias() + "," + p.getMinutoIncidente() + ",'" + p.getTipoTarjeta() + "',"
                + p.getMinutosJugados();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOtipoRegistro p) {

        String query = "delete from presidentes where jugadores_id = " + p.getJugadores_id();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }
}
