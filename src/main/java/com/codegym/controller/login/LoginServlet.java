package com.codegym.controller.login;

import com.codegym.model.*;
import com.codegym.service.payment.IPaymentService;
import com.codegym.service.payment.PaymentService;
import com.codegym.service.role.IRoleService;
import com.codegym.service.role.RoleService;
import com.codegym.service.shipment.IShipmentService;
import com.codegym.service.shipment.ShipmentService;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;
import com.codegym.service.userRole.IUserRoleService;
import com.codegym.service.userRole.UserRoleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private IUserService userService = new UserService();

    private IRoleService roleService = new RoleService();

    private IUserRoleService userRoleService = new UserRoleService();

    private IPaymentService paymentService = new PaymentService();

    private IShipmentService shipmentService = new ShipmentService();

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
            case "logout":
                logoutUser(request, response);
                break;
            case "register":
                registerUser(request, response);
                break;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/signup.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("roles");
        try {
            response.sendRedirect("/index");
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
            case "register":
                registerCustomer(request, response);
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
            List<Payment> payments = paymentService.getAll();
            List<Shipment> shipments = shipmentService.getAll();
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);
            session.setAttribute("roles", roles);
            session.setAttribute("paymentsSession", payments);
            session.setAttribute("shipmentsSession", shipments);
            for (Role role : roles) {
                if (role.getName().equals("Admin")){
                    try {
                        response.sendRedirect("/dashboard");
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                response.sendRedirect("/index");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void registerCustomer(HttpServletRequest request, HttpServletResponse response) {
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
            User user1 = new User(userName, password);
            int userId = userService.findIdByUser(user1);
            UserRole userRole = new UserRole(userId, 2);
            userRoleService.save(userRole);
            String message = "Registration success!";
            request.setAttribute("message", message);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
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
