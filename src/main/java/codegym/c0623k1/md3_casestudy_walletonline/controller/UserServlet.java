package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IUserService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.UserService;
import codegym.c0623k1.md3_casestudy_walletonline.util.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "userServlet", urlPatterns = "/user-servlet")
public class UserServlet extends HttpServlet {

    private final IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginUserForm(req,resp);
                break;
            case "register":
                registerUserForm(req, resp);
                break;
            case "edit":
                editUserForm(req, resp);
                break;
            case "delete":

                break;
            case "logout":
                logoutUser(req,resp);
                break;
            default:
                listUser(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "login":
                try {
                    loginUser(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "register":
                registerUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
            default:
                break;
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void editUserForm(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void logoutUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SessionUtil.getInstance().removeValue(req, "userName");
//        Thay đổi đường dẫn đến trang phù hợp
        resp.sendRedirect("index.jsp");
    }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        User user = new User(name, userName, password,address);
        this.userService.save(user);

        //Bổ sung trang điều hướng
        req.setAttribute("message", "New customer was created");
    }

    private void registerUserForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/registerForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if(this.userService.checkLogin(userName, password)){
            SessionUtil.getInstance().putValue(req,"userName", userName);
//            Thay đổi đường dẫn đến trang phù hợp
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("/user-servlet?action=login");
        }
    }

    private void loginUserForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/loginForm.jsp");
        dispatcher.forward(req, resp);
    }
}