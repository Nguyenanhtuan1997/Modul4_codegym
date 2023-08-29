package controller;

import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static sun.security.jgss.GSSUtil.login;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                showLoginForm(request, response);
                break;
            case "logout":
                logout(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/user?action=login");
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                login(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userService.checkUser(username, password)) {
            int id = userService.getIdUser(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("idUser", id);
            response.sendRedirect("/students?action=findAll");
        } else {
            response.sendRedirect("/user?action=login");
        }
    }
}
