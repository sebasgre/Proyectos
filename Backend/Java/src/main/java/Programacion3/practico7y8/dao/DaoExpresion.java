package Programacion3.practico7y8.dao;

import Programacion3.practico7y8.Lista.Lista2;
import Programacion3.practico7y8.dto.DTOexpresion;

public abstract class DaoExpresion {

    public abstract Lista2<DTOexpresion> getTodos();
    public abstract DTOexpresion getPorNombre(String nombre);
    public abstract DTOexpresion getPorExpresion(String expresion);
    public abstract void insert(DTOexpresion obj);
    public abstract void update(DTOexpresion obj);
    public abstract void delete(DTOexpresion obj);
    public abstract void deleteAll();
}
