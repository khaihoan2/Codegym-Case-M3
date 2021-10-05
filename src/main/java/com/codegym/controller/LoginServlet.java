package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

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
                signup(request, response);
                break;
            case "delete":
                deleteUser(request,response);
                break;

        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        try {
            response.sendRedirect("/login/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        Date created_at = Date.valueOf(request.getParameter("created_at"));
        User user = new User(username, password, first_name, last_name, address, email, telephone, created_at);
        userService.save(user);
        try {
            response.sendRedirect("/login/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean isValid = userService.login(username, password);
            RequestDispatcher dispatcher;
            if (isValid) {
                dispatcher = request.getRequestDispatcher("/order.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("/login/login.jsp");
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
                showSignUp(request, response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            case "update":

            default:
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User oldUser = userService.findById(id);
        RequestDispatcher dispatcher;
        if (oldUser == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/login/delete.jsp");
            request.setAttribute("user", oldUser);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showSignUp(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/login/signup.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/login/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
