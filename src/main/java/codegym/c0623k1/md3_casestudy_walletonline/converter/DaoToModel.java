package codegym.c0623k1.md3_casestudy_walletonline.converter;

import codegym.c0623k1.md3_casestudy_walletonline.dao.CategoryDAO;
import codegym.c0623k1.md3_casestudy_walletonline.dao.MoneyDAO;
import codegym.c0623k1.md3_casestudy_walletonline.dao.UserDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.model.Money;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IUserService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DaoToModel {
    static DaoToModel daoToModel;

    public static DaoToModel getInstance() {
        if (daoToModel == null) {
            daoToModel = new DaoToModel();
        }
        return daoToModel;
    }

    public User userDaoToModel(ResultSet mResultSet) throws SQLException {
        User user = new User();
        user.setId(mResultSet.getInt("id"));
        user.setName(mResultSet.getString("name"));
        user.setStatus(mResultSet.getInt("status"));
        user.setUserName(mResultSet.getString("userName"));
        user.setPassword(mResultSet.getString("password"));
        user.setAddress(mResultSet.getString("address"));
        user.setTotalMoney(mResultSet.getFloat("totalMoney"));
        return user;
    }

    public CategoryDetail categoryDetailDaoToModel(ResultSet mResultSet) throws SQLException {
        CategoryDetail categoryDetail = new CategoryDetail();
        categoryDetail.setId(mResultSet.getInt("id"));
        categoryDetail.setName(mResultSet.getString("name"));
        categoryDetail.setStatus(mResultSet.getInt("status"));
        categoryDetail.setRole(mResultSet.getInt("role"));
        Category category = new Category();
        category.setId(mResultSet.getInt("categoryID"));
        try {
            category.setName(mResultSet.getString("category.name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        categoryDetail.setCategory(category);
        return categoryDetail;
    }

    public Category categoryDaoToModel(ResultSet mResultSet) throws SQLException {
        Category category = new Category();
        category.setId(mResultSet.getInt("id"));
        category.setName(mResultSet.getString("name"));
        category.setStatus(mResultSet.getInt("status"));
        return category;
    }

    public Money moneyDaoToModel(ResultSet mResultSet) throws SQLException {
        Money money = new Money();
        User user = new User();
        user.setId(mResultSet.getInt("userId"));
        money.setUser(user);
        CategoryDetail categoryDetail = new CategoryDetail();
        categoryDetail.setId(mResultSet.getInt("categoryDetailId"));
        money.setCategoryDetail(categoryDetail);
        money.setMoney(mResultSet.getFloat("money"));
        money.setDescription(mResultSet.getString("description"));
        Timestamp time = mResultSet.getTimestamp("date");
        money.setDate(time.toLocalDateTime());
        return money;
    }
}
