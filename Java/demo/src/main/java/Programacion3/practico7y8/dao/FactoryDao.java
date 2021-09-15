package Programacion3.practico7y8.dao;

public abstract class FactoryDao {

    private static FactoryDao instance = null;

    public static FactoryDao getOrCreate(){
        if (instance == null)
            // Este es el unico otro lugar donde se cambia el codigo
            instance = new FactoryDaoSql();

        return instance;
    }

    public abstract DaoExpresion getDaoExpresion();

}
