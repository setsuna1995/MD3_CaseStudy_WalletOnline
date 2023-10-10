package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.converter.DaoToModel;
import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailDAO extends ConnectionUtil implements GeneralDAO<CategoryDetail> {
    DaoToModel converter = DaoToModel.getInstance();

    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public boolean update(CategoryDetail categoryDetail) throws SQLException {
        boolean rowUpdated;
        String sql = "update category_detail set name = ?,categoryId= ?, role =? where id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, categoryDetail.getName());
            mPreparedStatement.setInt(2, categoryDetail.getCategory().getId());
            mPreparedStatement.setInt(3, categoryDetail.getRole());
            mPreparedStatement.setInt(4, categoryDetail.getId());
            rowUpdated = mPreparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
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

    @Override
    public CategoryDetail findById(int id) {
            CategoryDetail categoryDetail = new CategoryDetail();
        String sql = "SELECT * FROM category_detail WHERE id = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, id);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                categoryDetail = converter.categoryDetailDaoToModel(mResultSet);
            }
            close();

            Category category = categoryDAO.findById(categoryDetail.getCategory().getId());
            categoryDetail.setCategory(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryDetail;
    }

    public List<CategoryDetail> findAllByCategoryID(int categoryID) {
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        String sql = "Select * from category_detail  join category on category_detail.categoryID = category.id " +
                "where categoryID = ? and category_detail.status = 1";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, categoryID);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                CategoryDetail categoryDetail = converter.categoryDetailDaoToModel(mResultSet);

                categoryDetailList.add(categoryDetail);
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryDetailList;
    }

    @Override
    public List<CategoryDetail> findAll() {
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        String sql = "Select * " +
                "from category_detail  join category on category_detail.categoryID = category.id " +
                "where category_detail.status = 1";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                CategoryDetail categoryDetail = converter.categoryDetailDaoToModel(mResultSet);
                categoryDetailList.add(categoryDetail);
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryDetailList;
    }

    @Override
    public void insert(CategoryDetail categoryDetail) {
        String sql = "INSERT INTO category_detail (`name`, `status`, `categoryId`, role) VALUES (?, 1, ?, ?)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            mPreparedStatement.setString(1, categoryDetail.getName());
            mPreparedStatement.setInt(2, categoryDetail.getCategory().getId());
            mPreparedStatement.setInt(3, categoryDetail.getRole());
            mPreparedStatement.executeUpdate();
            mResultSet = mPreparedStatement.getGeneratedKeys();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CategoryDetail> findAllByRole(int role) {
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        String sql = "Select * from category_detail  join category on category_detail.categoryID = category.id " +
                "where role = ? and category_detail.status = 1";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, role);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                CategoryDetail categoryDetail = converter.categoryDetailDaoToModel(mResultSet);

                categoryDetailList.add(categoryDetail);
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoryDetailList;
    }
}