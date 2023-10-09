package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.CategoryDetailDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryDetailService;

import java.sql.SQLException;
import java.util.List;

public class CategoryDetailService implements ICategoryDetailService {
 CategoryDetailDAO categoryDetailDAO = new CategoryDetailDAO();
    @Override
    public void add(CategoryDetail categoryDetail) throws SQLException {
        categoryDetailDAO.insert(categoryDetail);
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public void update(CategoryDetail categoryDetail) throws SQLException {
    }

    @Override
    public CategoryDetail findById(int id) {
        return null;
    }

    @Override
    public List<CategoryDetail> findAll() {
        return categoryDetailDAO.findAll();
    }

    @Override
    public List<CategoryDetail> findAllByCategoryID(int categoryID) {
        return categoryDetailDAO.findAllByCategoryID(categoryID);
    }
}
