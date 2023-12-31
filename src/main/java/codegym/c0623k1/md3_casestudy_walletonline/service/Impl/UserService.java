package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.UserDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private final UserDAO userDAO = new UserDAO();

    @Override
    public void save(User user) {
        userDAO.insert(user);
    }

    @Override
    public boolean checkLogin(String userName, String password) throws Exception {
        return userDAO.checkLogin(userName, password);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(String userName) throws Exception {
        return userDAO.findById(userName);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
