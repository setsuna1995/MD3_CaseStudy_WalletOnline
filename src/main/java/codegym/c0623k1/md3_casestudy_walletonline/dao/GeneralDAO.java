package codegym.c0623k1.md3_casestudy_walletonline.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T> {
    public T findById(int id);

    public List<T> findAll();
    public boolean update(T t) throws SQLException;
    public void insert (T t) throws SQLException;

    public boolean delete (int id) throws SQLException;


}
