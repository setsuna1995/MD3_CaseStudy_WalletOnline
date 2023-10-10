package codegym.c0623k1.md3_casestudy_walletonline.service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {
    public void add(T t) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(T t) throws SQLException;

    public T findById(int id);

    public List<T> findAll();
}
