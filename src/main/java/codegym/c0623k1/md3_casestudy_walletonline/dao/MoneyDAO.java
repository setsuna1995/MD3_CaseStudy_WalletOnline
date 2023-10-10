package codegym.c0623k1.md3_casestudy_walletonline.dao;

import codegym.c0623k1.md3_casestudy_walletonline.converter.DaoToModel;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.model.Money;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MoneyDAO extends ConnectionUtil {
    DaoToModel converter = DaoToModel.getInstance();
    UserDAO userDAO = new UserDAO();

    public Money findById(int idCategoryDetail, int idUser) {
        return null;
    }

    public List<Money> findAll(){
        List<Money> moneyList = new ArrayList<>();
        String sql = "Select * From money";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                Money money = converter.moneyDaoToModel(mResultSet);

                User user = new User();
                PreparedStatement preparedStatement1 = null;
                ResultSet resultSet1 = null;
                String sql1 = "Select * From user Where id = ?";
                preparedStatement1 = mConnection.prepareStatement(sql1);
                preparedStatement1.setInt(1, money.getUser().getId());
                resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    user = converter.userDaoToModel(resultSet1);
                }
                close(preparedStatement1);
                close(resultSet1);
                money.setUser(user);


                CategoryDetail categoryDetail = new CategoryDetail();
                PreparedStatement preparedStatement2 = null;
                ResultSet resultSet2 = null;
                String sql2 = "Select * From category_detail Where id = ?";
                preparedStatement2 = mConnection.prepareStatement(sql2);
                preparedStatement2.setInt(1, money.getCategoryDetail().getId());
                resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    categoryDetail = converter.categoryDetailDaoToModel(resultSet2);
                }
                close(preparedStatement2);
                close(resultSet2);
                money.setCategoryDetail(categoryDetail);

                moneyList.add(money);
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return moneyList;
    }

    public boolean update(Money money) throws SQLException {

        return false;
    }

    public void insert(Money money) throws SQLException {
        String sql = "INSERT INTO money (`userId`, `categoryDetailId`, `date`, `money`, `description`) VALUES (?, ?, ?, ?, ?)";

        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, money.getUser().getId());
            mPreparedStatement.setInt(2, money.getCategoryDetail().getId());
            mPreparedStatement.setObject(3, LocalDateTime.now());
            mPreparedStatement.setFloat(4, money.getMoney());
            mPreparedStatement.setString(5, money.getDescription());
            mPreparedStatement.executeUpdate();
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int idCategoryDetail, int idUser) throws SQLException {

        return false;
    }

    public List<Money> findAllByRole(int role) {
        List<Money> moneyList = new ArrayList<>();
        String sql = "Select * from money join category_detail on money.categoryDetailId = category_detail.id " +
                "where category_detail.role = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setInt(1, role);
            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                Money money = converter.moneyDaoToModel(mResultSet);


                User user = new User();
                PreparedStatement preparedStatement1 = null;
                ResultSet resultSet1 = null;
                String sql1 = "Select * From user Where id = ?";
                preparedStatement1 = mConnection.prepareStatement(sql1);
                preparedStatement1.setInt(1, money.getUser().getId());
                resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    user = converter.userDaoToModel(resultSet1);
                }
                close(preparedStatement1);
                close(resultSet1);
                money.setUser(user);

                moneyList.add(money);

            }
            close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return moneyList;
    }

    public List<Money> findAllToSearch(int month) {
        List<Money> moneyList = new ArrayList<>();
        String sql = "Select * From money where DATE_FORMAT(date, '%Y-%m') = ?";
        try {
            open();
            mPreparedStatement = mConnection.prepareStatement(sql);
            mPreparedStatement.setString(1, "2023-" + month);

            mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                Money money = converter.moneyDaoToModel(mResultSet);

                User user = new User();
                PreparedStatement preparedStatement1 = null;
                ResultSet resultSet1 = null;
                String sql1 = "Select * From user Where id = ?";
                preparedStatement1 = mConnection.prepareStatement(sql1);
                preparedStatement1.setInt(1, money.getUser().getId());
                resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    user = converter.userDaoToModel(resultSet1);
                }
                close(preparedStatement1);
                close(resultSet1);
                money.setUser(user);


                CategoryDetail categoryDetail = new CategoryDetail();
                PreparedStatement preparedStatement2 = null;
                ResultSet resultSet2 = null;
                String sql2 = "Select * From category_detail Where id = ?";
                preparedStatement2 = mConnection.prepareStatement(sql2);
                preparedStatement2.setInt(1, money.getCategoryDetail().getId());
                resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    categoryDetail = converter.categoryDetailDaoToModel(resultSet2);
                }
                close(preparedStatement2);
                close(resultSet2);
                money.setCategoryDetail(categoryDetail);

                moneyList.add(money);
            }
            close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return moneyList;
    }
}
