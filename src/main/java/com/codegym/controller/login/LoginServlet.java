package com.codegym.controller.login;

import com.codegym.model.User;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

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
                addUser(request, response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "search":
                findByName(request,response);
                break;


        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        userService.findByName(username);
        try {
            response.sendRedirect("/login/showAll.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        userService.deleteByName(username);
        try {
            response.sendRedirect("/login/showAll.jsp");
//            xóa xong chuyển sang trang login.`
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        Date created_at= Date.valueOf(request.getParameter("created_at"));
        User user = new User(username, password, first_name, last_name, address, telephone, email,created_at);
         boolean isCreated = userService.save(user);
         String message = " ";
         if (isCreated){
             message = "Create success";
         }else {
             message="Create fail";
         }
         RequestDispatcher dispatcher =request.getRequestDispatcher("/login/login.jsp");
         request.setAttribute("message",message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
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
                dispatcher = request.getRequestDispatcher("/index.jsp");
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
            case "delete":
                showDelete(request,response);
                break;
            default:
                showProductList(request,response);
                break;
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        String name =request.getParameter("q");
        List<User> users;
        if (name==null || name.equals("")){
            users=userService.getAll();
        }else {
            users=userService.findByName(name);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/list.jsp");
        request.setAttribute("users",users);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        List<User> oldUser = userService.findByName(username);
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


}
