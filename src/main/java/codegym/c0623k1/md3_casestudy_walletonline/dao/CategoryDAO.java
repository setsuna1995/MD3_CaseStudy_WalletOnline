package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends ConnectionUtil implements GeneralDAO <Category>{
    @Override
    public Category findById(int id) {
        return null;
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
}
