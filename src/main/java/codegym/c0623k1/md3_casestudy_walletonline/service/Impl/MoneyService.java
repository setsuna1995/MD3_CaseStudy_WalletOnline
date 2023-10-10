package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.CategoryDetailDAO;
import codegym.c0623k1.md3_casestudy_walletonline.dao.MoneyDAO;
import codegym.c0623k1.md3_casestudy_walletonline.dao.UserDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.model.Money;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IMoneyService;

import java.sql.SQLException;
import java.util.List;

public class MoneyService implements IMoneyService {

    UserDAO userDAO = new UserDAO();
    CategoryDetailDAO categoryDetailDAO = new CategoryDetailDAO();
    MoneyDAO moneyDAO = new MoneyDAO();

    @Override
    public void add(String userName, float money, int categoryDetailID, String description) throws SQLException {
        User user = userDAO.findByUserName(userName);
        CategoryDetail categoryDetail = categoryDetailDAO.findById(categoryDetailID);
        moneyDAO.insert(new Money(user, categoryDetail, description, money));
    }

    @Override
    public boolean delete(int idCategoryDetail, int idUser) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Money money) throws SQLException {
        return false;
    }

    @Override
    public List<Money> findAll() {
        return moneyDAO.findAll();
    }

    @Override
    public Money findById(int idCategoryDetail, int idUser) {
        return null;
    }

    @Override
    public List<Money> findAllByRole(int role) {
        return moneyDAO.findAllByRole(role);
    }

}
