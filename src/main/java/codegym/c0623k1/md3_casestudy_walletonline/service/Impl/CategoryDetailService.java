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
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(CategoryDetail categoryDetail) throws SQLException {
        return false;
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
