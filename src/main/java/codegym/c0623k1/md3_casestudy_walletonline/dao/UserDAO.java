package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.Statement;
import java.util.List;

public class UserDAO extends ConnectionUtil implements GeneralDAO<UserDAO>{

    public void insert(User user) {
        String sql = "INSERT INTO user (`name`, `userName`, `password`, `address`, `totalMoney`) VALUES (?, ?, ?, ?, 0)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mPreparedStatement.setString(1, user.getName());
            mPreparedStatement.setString(2, user.getUserName());
            mPreparedStatement.setString(3, user.getPassword());
            mPreparedStatement.setString(4, user.getAddress());
            mPreparedStatement.executeUpdate();
            mResultSet = mPreparedStatement.getGeneratedKeys();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkLogin(String username, String password) throws Exception{
        boolean blCheck = false;
        String sql = "select * from user where userName = ? and password = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, username);
            mPreparedStatement.setString(2, password);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                blCheck = true;
            }
        } finally {
            close();
        }
        return blCheck;
    }

    @Override
    public UserDAO findById(int id) {
        return null;
    }

    @Override
    public List<UserDAO> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
