package codegym.c0623k1.md3_casestudy_walletonline.service.Impl;

import codegym.c0623k1.md3_casestudy_walletonline.dao.CategoryDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public void add(Category category) throws SQLException {
        categoryDAO.insert(category);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return categoryDAO.delete(id);
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return categoryDAO.update(category);
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
