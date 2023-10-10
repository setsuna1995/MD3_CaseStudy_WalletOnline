package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.model.User;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryDetailServlet", urlPatterns = "/category-detail-servlet")
public class CategoryDetailServlet extends HttpServlet {
    private final ICategoryDetailService categoryDetailService = new CategoryDetailService();
    private final ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCategoryDetailForm(req, resp);
                break;
            case "edit":
                editCategoryDetailForm(req, resp);
                break;
            case "delete":
                try {
                    deleteCategoryDetail(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "find":
                listCategoryDetailByCategoryName(req, resp);
                break;
            case "showListByCategory":
                showCategoryDetailByCategoryNameForm(req, resp);
                break;
            default:
                listCategoryDetail(req, resp);
                break;
        }

    }

    private void listCategoryDetailByCategoryName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/find.jsp");
        List<Category> categoryList = categoryService.findAll();
        req.setAttribute("categories", categoryList);
        requestDispatcher.forward(req, resp);
    }

    private void showCategoryDetailByCategoryNameForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/list.jsp");
        int id = Integer.parseInt(req.getParameter("categoryID"));
        List<CategoryDetail> categoryDetailList = categoryDetailService.findAllByCategoryID(id);
        req.setAttribute("categoriesDetail", categoryDetailList);
        requestDispatcher.forward(req, resp);
    }

    private void deleteCategoryDetail(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        categoryDetailService.delete(id);
        listCategoryDetail(req, resp);
    }

    private void editCategoryDetailForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CategoryDetail categoryDetail = this.categoryDetailService.findById(id);
        RequestDispatcher dispatcher;
        if (categoryDetail == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("categoryDetail", categoryDetail);
            dispatcher = req.getRequestDispatcher("views/categoryDetail/categoryDetailInfoForm.jsp");
        }
        dispatcher.forward(req, resp);
    }

    private void listCategoryDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/list.jsp");
        List<CategoryDetail> categoryDetailList = categoryDetailService.findAll();
        req.setAttribute("categoriesDetail", categoryDetailList);
            requestDispatcher.forward(req, resp);
    }

    private void createCategoryDetailForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/categoryDetailInfoForm.jsp");
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
                    createCategoryDetail(req);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    editCategoryDetail(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                break;
        }
    }


    private void editCategoryDetail(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Category category = new Category();
        category.setId(Integer.parseInt(req.getParameter("categoryId")));
        int role = Integer.parseInt(req.getParameter("role"));
        CategoryDetail categoryDetail = new CategoryDetail(id, name, 1, category, role);
        categoryDetailService.update(categoryDetail);
        listCategoryDetail(req, resp);
    }

    private void createCategoryDetail(HttpServletRequest req) throws SQLException {
        String name = req.getParameter("name");
        int role = Integer.parseInt(req.getParameter("role"));
        Category category = new Category();
        category.setId(Integer.parseInt(req.getParameter("categoryId")));
        CategoryDetail categoryDetail = new CategoryDetail(name, 1, category, role);
        categoryDetailService.add(categoryDetail);
    }
}
