//package com.codegym.controller.user;
//
//import com.codegym.dao.user.UserDao;
//import com.codegym.model.User;
//import com.codegym.service.user.IUserService;
//import com.codegym.service.user.UserService;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.util.List;
//
//@WebServlet(name = "UserServlet", value = "/user")
//public class UserServlet extends HttpServlet {
//
//    private IUserService userService = new UserService();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createUser(request, response);
//                break;
//            case "login":
//                loginUser(request, response);
//                break;
//        }
//    }
//
//    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        User user = new User(userName, password);
//        int id = userService.findIdByUser(user);
//        if (id == -1) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
//            String message = "Incorrect account or password!";
//            request.setAttribute("message", message);
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginSuccess.jsp");
//            request.setAttribute("id", id);
//            request.setAttribute("userName", userName);
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void createUser(HttpServletRequest request, HttpServletResponse response) {
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String address = request.getParameter("address");
//        String telephone = request.getParameter("telephone");
//        String email = request.getParameter("email");
//        User user = new User(userName, password, firstName, lastName, address, telephone, email);
//        boolean isSave = userService.save(user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
//        if (isSave) {
//            String message = "Sign up success!";
//            request.setAttribute("message", message);
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            String message = "Registration failed!";
//            request.setAttribute("message", message);
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
