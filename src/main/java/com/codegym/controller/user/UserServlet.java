package com.codegym.controller.user;


import com.codegym.model.Brand;
import com.codegym.model.User;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "User1Servlet", value = "/users")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showUserCreate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            default:
                showUserList(request, response);
                break;

        }

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user",user);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<User> users;
        if (name==null ||name.equals("")){
            users=userService.getAll();
        }else {
            users=userService.findByName(name);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        request.setAttribute("users", users);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("user/delete.jsp");
        request.setAttribute("id", id);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserCreate(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.getAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
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
            case "update":
                update(request, response);
                break;
            case "return":
                returnUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                showUserList(request,response);

        }

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void returnUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        User user = new User(username, password, firstname, lastname, address, telephone, email);
        userService.update(id, user);
        request.setAttribute("user",user);

        try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
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
        userService.save(user);
        try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
