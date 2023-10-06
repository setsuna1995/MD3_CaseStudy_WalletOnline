package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.CategoryDetailDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryDetailService;

import java.sql.SQLException;
import java.util.List;

public class CategoryDetailService implements ICategoryDetailService {
    CategoryDetailDAO categoryDetailDAO = new CategoryDetailDAO();

    @Override
    public List<CategoryDetail> findAllByCategoryID(int id) {
        return categoryDetailDAO.findAllByCategoryID(id);
    }

    @Override
    public void add(CategoryDetail categoryDetail) throws SQLException {
        categoryDetailDAO.insert(categoryDetail);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return categoryDetailDAO.deleteCategoryDetail(id);
    }


    @Override
    public boolean update(CategoryDetail categoryDetail) throws SQLException {
        return categoryDetailDAO.updateCategoryDetail(categoryDetail);
    }

    @Override
    public CategoryDetail findById(int id) {
        return categoryDetailDAO.findById(id);
    }

    @Override
    public List<CategoryDetail> findAll() {
        return categoryDetailDAO.findAll();
    }
}
