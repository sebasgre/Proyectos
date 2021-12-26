package Programacion3.practico7y8.dao;

import Programacion3.practico7y8.Lista.Lista2;
import Programacion3.practico7y8.conexion.Conexion;
import Programacion3.practico7y8.dto.DTOexpresion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoSqlExpresion extends DaoExpresion {

    //public static Logger logger = LogManager.getLogger();

    @Override
    public Lista2<DTOexpresion> getTodos() {
        Lista2<DTOexpresion> resultado = null;
        String query = "select nombre, expresion from expresiones";
        ResultSet rs = null;
        try {
            Conexion conexion = Conexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (Exception e) {
//            logger.debug("No pudo ejecutar consulta");
        }
        try {
            resultado = new Lista2<DTOexpresion>();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String expresion = rs.getString("expresion");
                //recuerpo el entero como entero del iterador y recupero un string de la columna nombre
                resultado.add(new DTOexpresion(nombre, expresion));
            }
        } catch (SQLException e) {
//            logger.debug("Error recuperando datos del resultset: " + e.getMessage());
            System.out.println(e.getNextException());
        }
        return resultado;
    }

    @Override
    public DTOexpresion getPorNombre(String id){
        DTOexpresion resultado = null;
        String query = "Select nombre, expresion from expresiones where nombre = '" + id +"'";
        ResultSet rs = null;
        try {
            Conexion conexion = Conexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (Exception e) {
//            logger.debug("No se pudo ejecutar consulta");
            return resultado;
        }
        try {
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String expresion = rs.getString("expresion");
                resultado = new DTOexpresion(nombre, expresion);
            }
        } catch (SQLException e) {
//            logger.debug("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public DTOexpresion getPorExpresion(String expresion) {
        DTOexpresion resultado = null;
        String query = "Select nombre, expresion from expresiones where expresion = '" + expresion +"'";
        ResultSet rs = null;
        try {
            Conexion conexion = Conexion.getOrCreate();
            rs = conexion.ejecutarConsulta(query);
        } catch (Exception e) {
//            logger.debug("No se pudo ejecutar la consulta");
            return resultado;
        }
        try {
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String expresions = rs.getString("expresion");
                resultado = new DTOexpresion(nombre, expresions);
            }
        } catch (SQLException e) {
//            logger.debug("Error recuperando datos del resultset: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public void insert(DTOexpresion obj){
        String query = "insert into expresiones (nombre,expresion) values ('" + obj.getNombre() + "','" + obj.getExpresion() + "')";
        try {
            Conexion conexion = Conexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (Exception e) {
//            logger.debug("No se pudo ejecutar consulta insert");
        }
    }

    @Override
    public void update(DTOexpresion obj){
        String query = "update expresiones set expresion = '"+obj.getExpresion()+"' " +
                "where nombre = '"+obj.getNombre()+"'";
        try {
            Conexion conexion = Conexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (Exception e) {
//            logger.debug("No se pudo ejecutar la consulta update");
        }
    }

    @Override
    public void delete(DTOexpresion obj){
        String query = "delete from expresiones where nombre = '"+obj.getNombre()+"'";
        try {
            Conexion conexion = Conexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (Exception e) {
//            logger.debug("No se pudo ejecutar la consulta delete");
        }
    }

    @Override
    public void deleteAll(){
        String query = "delete from expresiones";
        try {
            Conexion conexion = Conexion.getOrCreate();
            conexion.ejecutarComando(query);
        } catch (Exception e) {
//            logger.debug("No se pudo ejecutar la consulta delete");
        }
    }
}
