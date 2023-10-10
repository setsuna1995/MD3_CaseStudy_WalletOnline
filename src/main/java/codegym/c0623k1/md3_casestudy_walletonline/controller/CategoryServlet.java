package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.dao.CategoryDAO;
import codegym.c0623k1.md3_casestudy_walletonline.dao.GeneralDAO;
import codegym.c0623k1.md3_casestudy_walletonline.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "categoryServlet", urlPatterns = "/category-servlet")
public class CategoryServlet extends HttpServlet {
    GeneralDAO<Category> categoryDAO = new CategoryDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("act");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                try {
                    deleteCategory(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
//                showDeleteCategoryForm(request, response);
            default:
                showList(request, response);
                break;
        }
    }

//    private void showDeleteCategoryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/category/deleteCategoryForm.jsp");
//        requestDispatcher.forward(request, response);
//    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDAO.findAll();
        for (Category item : categories){
            System.out.println(item);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/category/categoryList.jsp");
        request.setAttribute("cat", categories);
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("act");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
//                deleteCategory(request, response);
                break;
        }
    }
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
//        boolean deleted = this.categoryDAO.delete(categoryId);
//
//        if (deleted){
//            response.sendRedirect("views/category/categoryList.jsp");
//        } else {
//            response.getWriter().println("ID does not exist!!!");
//        }
        categoryDAO.delete(categoryId);

        List<Category> categoryList = categoryDAO.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/category/categoryList.jsp");
        requestDispatcher.forward(request, response);
    }


}
