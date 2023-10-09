package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends ConnectionUtil implements GeneralDAO<User> {

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

    @Override
    public boolean update(User user) {
        String sql = "UPDATE user SET name = ?, userName = ?, password = ?, address = ? WHERE id = ?";
        boolean check = false;
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, user.getName());
            mPreparedStatement.setString(2, user.getUserName());
            mPreparedStatement.setString(3, user.getPassword());
            mPreparedStatement.setString(4, user.getAddress());
            mPreparedStatement.setInt(5, user.getUserId());
            check = mPreparedStatement.executeUpdate() > 0;
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public boolean remove(int id) {
        String sql = "UPDATE user SET status = 0 WHERE id = ?";
        boolean check = false;
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, id);
            check = mPreparedStatement.executeUpdate() > 0;
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public User findById(int id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, id);
            mResultSet = mPreparedStatement.executeQuery();

            while (mResultSet.next()) {
                user.setUserId(mResultSet.getInt("id"));
                user.setName(mResultSet.getString("name"));
                user.setUserName(mResultSet.getString("userName"));
                user.setPassword(mResultSet.getString("password"));
                user.setAddress(mResultSet.getString("address"));
                user.setTotalMoney(mResultSet.getFloat("totalMoney"));
                user.setStatus(mResultSet.getInt("status"));
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();

            while (mResultSet.next()) {
                User user = new User();
                user.setUserId(mResultSet.getInt("id"));
                user.setName(mResultSet.getString("name"));
                user.setUserName(mResultSet.getString("userName"));
                user.setPassword(mResultSet.getString("password"));
                user.setAddress(mResultSet.getString("address"));
                user.setTotalMoney(mResultSet.getFloat("totalMoney"));
                user.setStatus(mResultSet.getInt("status"));
                users.add(user);
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public boolean checkLogin(String username, String password) throws Exception {
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
}
