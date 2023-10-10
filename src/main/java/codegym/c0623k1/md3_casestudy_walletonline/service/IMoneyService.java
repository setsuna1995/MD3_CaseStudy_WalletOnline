package codegym.c0623k1.md3_casestudy_walletonline.service;

import codegym.c0623k1.md3_casestudy_walletonline.model.Money;

import java.sql.SQLException;
import java.util.List;

public interface IMoneyService {
    public void add(String userName, float money, int categoryID, String description) throws SQLException;

    public boolean delete(int idCategoryDetail, int idUser) throws SQLException;

    public boolean update(Money money) throws SQLException;

    public List<Money> findAll();

    public Money findById(int idCategoryDetail, int idUser);

    List<Money> findAllByRole(int role);
}
