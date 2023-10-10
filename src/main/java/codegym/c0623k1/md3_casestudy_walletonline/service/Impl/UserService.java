package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.UserDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private final UserDAO userDAO = new UserDAO();

    @Override
    public boolean checkLogin(String userName, String password) throws Exception {
        return userDAO.checkLogin(userName, password);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }


    @Override
    public void add(User user) throws SQLException {
        userDAO.insert(user);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return userDAO.delete(id);
    }

    @Override
    public boolean update(User user) throws SQLException {
        return userDAO.update(user);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }
}
