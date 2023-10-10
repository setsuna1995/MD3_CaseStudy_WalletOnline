package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends ConnectionUtil implements GeneralDAO<Category> {
    public CategoryDAO() {
    }

    @Override
    public Category findById(int categoryId) {
        Category category = null;
        try (Connection connection = getConnection("jdbc:mysql://localhost:3306/expense_management?useSSL=false", "root", "123456");

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category where id = ?");) {
            preparedStatement.setInt(1, categoryId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("id"));
                category.setCategoryName(rs.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection("jdbc:mysql://localhost:3306/expense_management?useSSL=false", "root", "123456");

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category")) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int categoryId = rs.getInt("id");
                String categoryName = rs.getString("name");
                categories.add(new Category(categoryId, categoryName));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean delete(int categoryId) throws SQLException {
        boolean rowsAffected;
        try (Connection connection = getConnection("jdbc:mysql://localhost:3306/expense_management?useSSL=false", "root", "123456");

             PreparedStatement preparedStatement = connection.prepareStatement("delete from category where id = ?");) {
            preparedStatement.setInt(1, categoryId);
            rowsAffected = preparedStatement.executeUpdate() > 0;
        }
        finally {
            try {
                close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return rowsAffected;
    }
}
