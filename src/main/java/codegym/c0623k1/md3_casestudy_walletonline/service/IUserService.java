package codegym.c0623k1.md3_casestudy_walletonline.service;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    boolean checkLogin(String userName, String password) throws Exception;

    List<User> findAll();

    User findById(String userName) throws Exception;

    void update(User user);

    void delete(int id);
}
