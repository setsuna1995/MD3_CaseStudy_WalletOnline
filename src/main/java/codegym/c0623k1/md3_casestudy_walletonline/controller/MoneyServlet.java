package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryDetailService;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.CategoryDetailService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "moneyServlet", value = "/money-servlet")
public class MoneyServlet extends HttpServlet {
    private final ICategoryService categoryService = new CategoryService();
    private final ICategoryDetailService categoryDetailService = new CategoryDetailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryID = req.getParameter("category");
        String action = req.getParameter("action");

        if(categoryID != null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/list.jsp");
            List<CategoryDetail> categoryDetailList = categoryDetailService.findAllByCategoryID(Integer.parseInt(categoryID));
            req.setAttribute("categoriesDetail", categoryDetailList);
            requestDispatcher.forward(req, resp);
        }
        if(action.equals("pay")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/money-category.jsp");
            List<Category> categoryList = categoryService.findAll();
            req.setAttribute("categories", categoryList);
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
