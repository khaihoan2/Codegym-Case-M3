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

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String action = request.getParameter("action");
     if (action==null){
         action="";
     }
     switch (action){
         case "create":
             addUser(request,response);
             break;
         case "edit":
             update(request,response);
             break;
         case "delete":
             deleteByUserName(request,response);
             break;
     }
    }

    private void deleteByUserName(HttpServletRequest request, HttpServletResponse response) {
        String username= request.getParameter("username");
        userService.deleteByName(username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/delete.jsp");
        request.setAttribute("username",username);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String usernameSet=request.getParameter("username_set");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        Date last_modified = Date.valueOf(request.getParameter("crated_at"));
        User user=new User(username, password,first_name,last_name,address,telephone,email,last_modified);
        userService.updateByName(usernameSet,user);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/user/edit.jsp");
        request.setAttribute("user",user);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        Date created_at= Date.valueOf(request.getParameter("created_at"));
        User user = new User(username, password, first_name, last_name, address, telephone, email,created_at);
        userService.save(user);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/user/create.jsp");
        request.setAttribute("user",user);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            switch (action){
                case "create":
                    showAdd(request,response);
                    break;
                case "delete":
                    showDeleteFrom(request,response);
                    break;
            }
        }
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        List<User> oldUser = userService.findByName(username);
        RequestDispatcher dispatcher;
        if (oldUser==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            dispatcher=request.getRequestDispatcher("/user/delete.jsp");
            request.setAttribute("user",oldUser);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/create.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
