package SQL.BD1.Proyecto.consola;

import Java.Programacion3.Lista.Lista2;
import SQL.BD1.Proyecto.modelo.DAOpersona;
import SQL.BD1.Proyecto.modelo.DTOpersona;

public class consola {
    public static void main(String[] args) {

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
	}
}
