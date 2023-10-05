package codegym.c0623k1.md3_casestudy_walletonline.service;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;

public interface IUserService {
    void save(User user);

    boolean checkLogin(String userName, String password) throws Exception;
}
