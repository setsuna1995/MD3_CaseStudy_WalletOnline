package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category-servlet")
public class CategoryServlet extends HttpServlet {
    private final ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                    createCategoryForm(req,resp);
                break;
            case "edit":
//                editCategoryForm(req, resp);
                break;
            default:
                listCategory(req, resp);
                break;
        }

    }

    private void createCategoryForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/category/addCategory.jsp");
        requestDispatcher.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createCategory(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
//                editCategoryForm(req, resp);
                break;
            default:
//                listCategory(req, resp);
                break;
        }
    }
    private void createCategory(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String name = req.getParameter("name");
        Category category = new Category(name);
        categoryService.add(category);
        req.setAttribute("message", "New category was created");
    }

    private void listCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/category/list.jsp");
        List<Category> categoryList = categoryService.findAll();
        req.setAttribute("categories", categoryList);
        requestDispatcher.forward(req, resp);
    }
}
