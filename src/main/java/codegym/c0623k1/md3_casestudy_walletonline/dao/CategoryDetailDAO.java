package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailDAO extends ConnectionUtil implements GeneralDAO<CategoryDetail> {
    @Override
    public CategoryDetail findById(int categoryId) {
        CategoryDetail categoryDetail = new CategoryDetail();
        String sql = "select * from category_detail where categoryID = ?";
        try {

             {
                 open();
                 mPreparedStatement = mConnection.prepareStatement(sql);
                mPreparedStatement.setInt(1, categoryId);
                ResultSet rs = mPreparedStatement.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
//                    categoryDetail = new CategoryDetail(categoryId, name);
                }
        }

        } catch (SQLException e) {
        }
        return categoryDetail;
    }

    public List<CategoryDetail> findAllByCategoryID(int categoryID) {
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        String sql = "Select * from category_detail join category on category_detail.categoryID = category.id where categoryID = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, categoryID);
            checkID(categoryDetailList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryDetailList;
    }

    private void checkID(List<CategoryDetail> categoryDetailList) throws Exception {
        mResultSet = mPreparedStatement.executeQuery();
        while (mResultSet.next()) {
            int id = mResultSet.getInt("id");
            String name = mResultSet.getString("name");
            int status = mResultSet.getInt("status");
            int categoryId = mResultSet.getInt("categoryID");
            int role = mResultSet.getInt("role");
            categoryDetailList.add(new CategoryDetail(id, name, status, categoryId, role));
        }
        close();
    }

    @Override
    public List<CategoryDetail> findAll() {
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        String sql = "Select * from category_detail where status = 1";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            checkID(categoryDetailList);
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

    public boolean updateCategoryDetail(CategoryDetail categoryDetail) {
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

    public boolean deleteCategoryDetail(int id) {
        boolean rowDeleted;
        String sql = "update category_detail set status = 0 where id = ?";
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
}
