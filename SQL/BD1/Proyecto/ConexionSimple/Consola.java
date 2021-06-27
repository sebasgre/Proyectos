package SQL.BD1.Proyecto.ConexionSimple;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.modelo.DAOpersona;
import SQL.BD1.Proyecto.modelo.DTOpersona;

public class Consola {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        DAOpersona dao = new DAOpersona();

        // SELECTS
        Lista2<DTOpersona> personas = dao.getTodos();
        for (DTOpersona p : personas) {
            System.out.println(p);
        }

        // CRUD
        DTOpersona h = dao.getPorId(1);
        System.out.println(h);
        h.setNombre("huguito");
        dao.actualizar(h);
        /*
         * con.conectarMySQL(); con.obtenerSQL("SELECT * FROM directoresAdmins");
         */
    }
}
