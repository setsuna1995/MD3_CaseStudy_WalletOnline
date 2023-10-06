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
    public boolean delete(CategoryDetail categoryDetail) throws SQLException {
        return categoryDetailDAO.deleteCategoryDetail(categoryDetail);
    }


    @Override
    public boolean update(CategoryDetail categoryDetail) throws SQLException {
        return categoryDetailDAO.updateCategoryDetail(categoryDetail);
    }

    @Override
    public CategoryDetail findById(int id) {
        return null;
    }

    @Override
    public List<CategoryDetail> findAll() {
        return categoryDetailDAO.findAll();
    }
}
