package com.codegym.controller.order;

import com.codegym.service.orderItem.IOrderItemService;
import com.codegym.service.orderItem.OrderItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderDetailServlet", value = "/orderDetail")
public class OrderDetailServlet extends HttpServlet {
    private OrderItemService orderItemService = new OrderItemService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                showDelete(request, response);
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/orderDetail/delete.jsp");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteOrderItem(request, response);
                break;
        }

    }

    private void deleteOrderItem(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderItemService.delete(productId, orderId);
        try {
            response.sendRedirect("/order?action=detail&id=" + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
