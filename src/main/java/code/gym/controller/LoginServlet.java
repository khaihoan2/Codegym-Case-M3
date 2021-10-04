package code.gym.controller;


import code.gym.model.User;
import code.gym.service.user.IUserService;
import code.gym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginUser(request, response);
                break;
            case "signup":
                singup(request, response);
                break;
            default:
                break;

        }
    }

    private void singup(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        Date create_at = Date.valueOf(request.getParameter("create_at"));
        User user = new User(username, password, first_name, last_name, address, email, telephone, create_at);
        userService.save(user);
        try {
            response.sendRedirect("/Login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean isValid = userService.Login(username, password);
            RequestDispatcher dispatcher;
            if (isValid) {
                dispatcher = request.getRequestDispatcher("Order.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("/Login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showLogin(request, response);
                break;
            case "signup":
                showsingup(request, response);
                break;
            default:
                break;
        }

    }

    private void showsingup(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("signup.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("Login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
