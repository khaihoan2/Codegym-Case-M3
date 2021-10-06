package com.codegym.controller.user;

import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.role.IRoleService;
import com.codegym.service.role.RoleService;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {

    private IUserService userService = new UserService();

    private IRoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":
                logoutUser(request, response);
                break;
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("roles");
        try {
            response.sendRedirect("/index.jsp");
        } catch (IOException e) {
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
            case "create":
                createUser(request, response);
                break;
            case "login":
                loginUser(request, response);
                break;
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User(userName, password);
        int userId = userService.findIdByUser(user);
        if (userId == -1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
            String message = "Incorrect account or password!";
            request.setAttribute("message", message);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            List<Role> roles = roleService.getRolesByUserId(userId);
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);
            session.setAttribute("roles", roles);
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        User user = new User(userName, password, firstName, lastName, address, telephone, email);
        boolean isSave = userService.save(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
        if (isSave) {
            String message = "Sign up success!";
            request.setAttribute("message", message);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String message = "Registration failed!";
            request.setAttribute("message", message);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
