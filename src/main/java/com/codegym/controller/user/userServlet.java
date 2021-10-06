package com.codegym.controller.user;

import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user")
public class userServlet extends HttpServlet {
    private IUserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "login":
                loginUser(request,response);
                break;
            case "Register":
                CreateUser(request,response);
                break;
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    }

    private void CreateUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String address= request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        boolean isSave = userDao.save(new User(username,password,firstname,lastname,address,telephone,email));
        RequestDispatcher dispatcher;
        if (isSave){
            dispatcher = request.getRequestDispatcher("/user/create.jsp");
            String mess = "register success";
            request.setAttribute("mess",mess);
            try {
                dispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }else {
            dispatcher =request.getRequestDispatcher("/user/login.jsp");
            String mess = "register faild";
            request.setAttribute("mess",mess);
            try {
                dispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
