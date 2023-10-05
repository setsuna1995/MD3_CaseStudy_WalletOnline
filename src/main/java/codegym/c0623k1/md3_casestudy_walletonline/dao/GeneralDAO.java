package codegym.c0623k1.md3_casestudy_walletonline.dao;

import java.util.List;

public interface GeneralDAO<T> {
    public T findById(int id);

    public List<T> findAll();
}
