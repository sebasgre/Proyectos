package SQL.BD1.Proyecto.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.dal.DSConexion;
import SQL.BD1.Proyecto.dto.DTOequipos;

public class DAOequipos {

    public Lista2<DTOequipos> getTodos(){
        Lista2<DTOequipos> resultado = null;
        String query = "select codigo, nombre, pais, presidente_id, directoresTecnicos_id from equipos";
        ResultSet rs = null;
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
            return resultado;
        }
        try {
            resultado = new Lista2<DTOequipos>();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                int presidente_id = rs.getInt("presidente_id");
                int directoresTecnicos_id = rs.getInt("directoresTecnicos_id");
                //recuerpo el entero como entero del iterador y recupero un string de la columna nombre
                resultado.add(new DTOequipos(codigo, nombre, pais, presidente_id, directoresTecnicos_id));
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public DTOequipos getPorId(int id){
        DTOequipos resultado = null;
        String query = "select codigo, nombre, pais, presidente_id, directoresTecnicos_id from equipos where codigo = " + id;

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
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                int presidente_id = rs.getInt("presidente_id");
                int directoresTecnicos_id = rs.getInt("directoresTecnicos_id");
                //recuerpo el entero como entero del iterador y recupero un string de la columna nombre
                resultado = new DTOequipos(codigo, nombre, pais, presidente_id, directoresTecnicos_id);
            }
        } catch (SQLException e) {
            System.out.println("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    public void actualizar(DTOequipos p){

        String query = "update equipos set nombre = '" + p.getNombre() + "' where codigo = " + p.getCodigo();
        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void insertar(DTOequipos p){

        String query = "insert into equipos (codigo, nombre, pais, presidente_id, directoresTecnicos_id) values (" +
                p.getCodigo()+",'"+p.getNombre()+"','"+p.getPais()+"',"+p.getPresidente_id()+","+p.getDirectoresTecnicos_id()+")";

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    public void eliminar(DTOequipos p){

        String query = "delete from equipos where codigo = " + p.getCodigo();

        try {
            DSConexion conexion = DSConexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (SQLException e) {
            System.out.println("No pudo ejecutar consulta");
        }
    }

    
}
