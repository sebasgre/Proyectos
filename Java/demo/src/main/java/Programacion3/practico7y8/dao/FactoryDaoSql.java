package Java.demo.src.main.java.Programacion3.practico7y8.dao;

public class FactoryDaoSql extends FactoryDao{

    public FactoryDaoSql() {

    }

    @Override
    public DaoExpresion getDaoExpresion() {
        return new DaoSqlExpresion();
    }
}
