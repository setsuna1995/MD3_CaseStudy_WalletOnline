package codegym.c0623k1.md3_casestudy_walletonline.service;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;

import java.util.List;

public interface IUserService extends IGeneralService<User>{

    boolean checkLogin(String userName, String password) throws Exception;

}
