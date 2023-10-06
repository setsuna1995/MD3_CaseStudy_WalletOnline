package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.Category;
import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;
import codegym.c0623k1.md3_casestudy_walletonline.service.ICategoryDetailService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.CategoryDetailService;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCategoryDetailForm(req,resp);
                break;
            case "edit":
                editCategoryDetailForm(req, resp);
                break;
            default:
                listCategoryDetail(req, resp);
                break;
        }

    }

    private void editCategoryDetailForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/editCategoryDetail.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void listCategoryDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/list.jsp");
        List<CategoryDetail> categoryDetailList = categoryDetailService.findAll();
        req.setAttribute("categoriesDetail", categoryDetailList);
        requestDispatcher.forward(req, resp);
    }
    private void createCategoryDetailForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/categoryDetail/addCategoryDetail.jsp");
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
                    createCategoryDetail(req,resp);
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
//                listCategory(req, resp);
                break;
        }
    }

    private void editCategoryDetail(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        int role = Integer.parseInt(req.getParameter("role"));
        CategoryDetail categoryDetail = new CategoryDetail(id, name, 1, categoryId, role);
        categoryDetailService.update(categoryDetail);
        req.setAttribute("message", "New category detail was edited");
    }

    private void createCategoryDetail(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String name = req.getParameter("name");
        int role = Integer.parseInt(req.getParameter("role"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        CategoryDetail categoryDetail = new CategoryDetail(name, 1, categoryId, role);
        categoryDetailService.add(categoryDetail);
        req.setAttribute("message", "New category detail was created");
    }
}
