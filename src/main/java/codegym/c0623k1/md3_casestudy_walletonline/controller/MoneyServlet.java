package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.model.Money;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryDetailService;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryService;
import codegym.c0623k1.md3_casestudy_walletonline.service.IMoneyService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.CategoryDetailService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.CategoryService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.MoneyService;
import codegym.c0623k1.md3_casestudy_walletonline.util.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "moneyServlet", value = "/money-servlet")
public class MoneyServlet extends HttpServlet {

    private final IMoneyService moneyService = new MoneyService();
    private final ICategoryDetailService categoryDetailService = new CategoryDetailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "payMoney":
            case "collectMoney":
                listCategoryDetailByRole(action, req, resp);
                break;
            case "list":
            case "listCollectMoney":
            case "listPayMoney":
                list(action, req, resp);
                break;
            case  "listToMonth":
                formSearch(req, resp);
                break;
            case "update":
                updateMoney(req, resp);
                break;
            default:
                break;
        }
    }

    private void updateMoney(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "payMoney":
            case "collectMoney":
                try {
                    createMoney(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "listToMonth":
                searchMoneyToMonth(req, resp);
                break;
            default:
                break;
        }
    }

    private void searchMoneyToMonth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int month = Integer.parseInt(req.getParameter("searchMonth"));
        List<Money> moneyList = moneyService.findAllToSearch(month);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/money/list.jsp");
        req.setAttribute("moneyList", moneyList);
        requestDispatcher.forward(req, resp);
    }

    private void formSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/money/searchForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void list(String action, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/money/list.jsp");
        List<Money> moneyList = new ArrayList<>();
        if(action.equals("listPayMoney")) {
            moneyList = moneyService.findAllByRole(1);
        } else if (action.equals("listCollectMoney")) {
            moneyList = moneyService.findAllByRole(0);
        } else if (action.equals("list")) {
            moneyList = moneyService.findAll();
        }
        req.setAttribute("moneyList", moneyList);
        requestDispatcher.forward(req, resp);
    }

    private void createMoney(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String userName = (String) SessionUtil.getInstance().getValue(req, "userName");
        float money = Float.parseFloat(req.getParameter("money"));
        int categoryDetailID = Integer.parseInt(req.getParameter("categoryDetailID"));
        String description = req.getParameter("description");
        moneyService.add(userName, money, categoryDetailID, description);
    }

    private void listCategoryDetailByRole(String action, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/money/pay.jsp");
        List<CategoryDetail> categoryDetailList = new ArrayList<>();
        if(action.equals("payMoney")) {
            categoryDetailList = categoryDetailService.findAllByRole(1);
        } else if (action.equals("collectMoney")) {
            categoryDetailList = categoryDetailService.findAllByRole(0);
        }
        req.setAttribute("categories", categoryDetailList);
        requestDispatcher.forward(req, resp);
    }
}
