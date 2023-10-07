package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends ConnectionUtil implements GeneralDAO <Category>{
    public Category findByCondition(int id) {
        return null;
    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        String sql = "select * from category where id = ?";
        try
             {
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
            String sql = "Select * from category";
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                int id = mResultSet.getInt("id");
                String name = mResultSet.getString("name");
                categoryList.add(new Category(id, name));
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }
    public void insert(Category category) {
        String sql = "INSERT INTO category (`name`) VALUES (?)";

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
    public boolean updateCategory (Category category) {
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
}
