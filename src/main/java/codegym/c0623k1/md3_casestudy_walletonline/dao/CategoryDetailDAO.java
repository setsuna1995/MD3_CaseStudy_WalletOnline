package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailDAO extends ConnectionUtil implements GeneralDAO<CategoryDetail>{
    @Override
    public CategoryDetail findById(int id) {

        return null;
    }

    @Override
    public List<CategoryDetail> findAll() {
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        try {
            open();
            String sql = "Select * from category_detail where status = 1";
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                int id = mResultSet.getInt("id");
                String name = mResultSet.getString("name");
                int status = mResultSet.getInt("status");
                int categoryId = mResultSet.getInt("categoryId");
                int role = mResultSet.getInt("role");
                categoryDetailList.add(new CategoryDetail(id, name, status, categoryId, role));
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryDetailList;
    }
    public void insert(CategoryDetail categoryDetail) {
        String sql = "INSERT INTO category_detail (`name`, `status`, `categoryId`, role) VALUES (?, 1, ?, ?)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mPreparedStatement.setString(1, categoryDetail.getName());
            mPreparedStatement.setInt(2, categoryDetail.getCategoryID());
            mPreparedStatement.setInt(3, categoryDetail.getRole());
            mPreparedStatement.executeUpdate();
            mResultSet = mPreparedStatement.getGeneratedKeys();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateCategoryDetail (CategoryDetail categoryDetail) {
        boolean rowUpdated;
        String sql = "update category_detail set name = ?,categoryId= ?, role =? where id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, categoryDetail.getName());
            mPreparedStatement.setInt(2, categoryDetail.getCategoryID());
            mPreparedStatement.setInt(3, categoryDetail.getRole());
            mPreparedStatement.setInt(4, categoryDetail.getId());
            rowUpdated = mPreparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
    public boolean deleteCategoryDetail (CategoryDetail categoryDetail) {
        boolean rowDeleted;
        String sql = "update category_detail set status = 0 where id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, categoryDetail.getId());
            rowDeleted = mPreparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
}
