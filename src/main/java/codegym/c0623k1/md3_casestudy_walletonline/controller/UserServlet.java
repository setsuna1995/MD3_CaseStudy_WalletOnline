package codegym.c0623k1.md3_casestudy_walletonline.controller;

import codegym.c0623k1.md3_casestudy_walletonline.model.User;
import codegym.c0623k1.md3_casestudy_walletonline.service.IUserService;
import codegym.c0623k1.md3_casestudy_walletonline.service.Impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "userServlet", urlPatterns = "/user-servlet")
public class UserServlet extends HttpServlet {

    private final IUserService userService = new UserService();
    private String userName;

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
                try {
                    editUserForm(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "view":
                try {
                    view(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    delete(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
                try {
                    editUser(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

        private void editUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String address = req.getParameter("address");
            User user = new User(id, name, userName, password,address);
            this.userService.update(user);
            listUser(req,resp);
        }
        private void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
            int id = Integer.parseInt(req.getParameter("id"));
            this.userService.delete(id);
        }

    private void editUserForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("userName");
        User user = this.userService.findById(userName);
        req.setAttribute("user",user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/editForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("userName");
        User user = this.userService.findById(userName);
        System.out.println(user);
        req.setAttribute("user",user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/viewUser.jsp");
        dispatcher.forward(req, resp);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = this.userService.findAll();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void logoutUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("userName");
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
            req.setAttribute("userName", userName);
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
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
