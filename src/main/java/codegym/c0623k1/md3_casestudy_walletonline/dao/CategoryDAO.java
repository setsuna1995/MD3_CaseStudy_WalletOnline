package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends ConnectionUtil implements GeneralDAO <Category> {


    @Override
    public Category findById(int id) {
        Category category = new Category();
        String sql = "select * from category where id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, id);
            ResultSet rs = mPreparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            open();
            String sql = "Select * from category where status = 1";
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                int id = mResultSet.getInt("id");
                String name = mResultSet.getString("name");
                int status = mResultSet.getInt("status");
                categoryList.add(new Category(id, name, status));
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        boolean rowUpdated;
        String sql = "update category set name = ? where id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, category.getName());
            mPreparedStatement.setInt(2, category.getId());
            rowUpdated = mPreparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        String sql = "update category set status = 0 where id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, id);
            rowDeleted = mPreparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO category (`name`, `status`) VALUES (?, 1)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mPreparedStatement.setString(1, category.getName());
            mPreparedStatement.executeUpdate();
            mResultSet = mPreparedStatement.getGeneratedKeys();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
