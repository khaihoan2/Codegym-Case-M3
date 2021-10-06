package com.codegym.controller;

import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final IUserService USER_SERVICE = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register": {
                showRegisterForm(request, response);
                break;
            }
            case "recover": {
                showRecoverForm(request, response);
                break;
            }
            case "": {
                showLoginForm(request, response);
                break;
            }
            default: {
                show404ErrorPage(request, response);
            }
        }
    }

    private void show404ErrorPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error-404.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showRecoverForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/recover.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register": {
                doRegister(request, response);
                break;
            }
            case "recover": {
                doRecover(request, response);
                break;
            }
            case "": {
                doLogin(request, response);
                break;
            }
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) {

    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response) {
    }

    private void doRecover(HttpServletRequest request, HttpServletResponse response) {
    }
}
