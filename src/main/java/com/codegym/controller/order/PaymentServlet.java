package com.codegym.controller.order;

import com.codegym.model.Payment;
import com.codegym.service.payment.IPaymentService;
import com.codegym.service.payment.PaymentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/payment")
public class PaymentServlet extends HttpServlet {
    private IPaymentService paymentService = new PaymentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/payment/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Payment payment = paymentService.findById(id);
        request.setAttribute("payment", payment);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/payment/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/payment/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Payment> payments = paymentService.getAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/payment/list.jsp");
        request.setAttribute("payments", payments);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
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
                createPayment(request, response);
                break;
            case "edit":
                editPayment(request, response);
                break;
            case "delete":
                deletePayment(request, response);
                break;
        }

    }

    private void editPayment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Payment payment = new Payment(id, name);
        paymentService.update(id, payment);
        try {
            response.sendRedirect("/payment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        paymentService.remove(id);
        try {
            response.sendRedirect("/payment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createPayment(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Payment payment = new Payment(name);
        paymentService.save(payment);
        try {
            response.sendRedirect("/payment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
