package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.UserDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IUserService;

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
}
