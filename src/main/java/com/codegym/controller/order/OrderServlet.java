package com.codegym.controller.order;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Payment;
import com.codegym.model.Shipment;
import com.codegym.service.order.IOrderService;
import com.codegym.service.order.OrderService;
import com.codegym.service.orderItem.IOrderItemService;
import com.codegym.service.orderItem.OrderItemService;
import com.codegym.service.payment.IPaymentService;
import com.codegym.service.payment.PaymentService;
import com.codegym.service.shipment.IShipmentService;
import com.codegym.service.shipment.ShipmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    private IOrderService orderService = new OrderService();

    private IShipmentService shipmentService = new ShipmentService();

    private IPaymentService paymentService = new PaymentService();

    private IOrderItemService orderItemService = new OrderItemService();

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
            case "detail":
                showDetail(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                showList(request, response);
                break;
        }

    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/detail.jsp");
        request.setAttribute("order", order);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/order/create.jsp");
        int userId = Integer.parseInt(request.getParameter("userId"));
            request.setAttribute("userId", userId);
        List<Payment> payments = paymentService.getAll();
        request.setAttribute("payments", payments);
        List<Shipment> shipments = shipmentService.getAll();
        request.setAttribute("shipments", shipments);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findById(id);
        request.setAttribute("order", order);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orders = orderService.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/list.jsp");
        request.setAttribute("orders", orders);
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
            case "create":
                createOrder(request, response);
                break;
            case "delete":
                deleteOrder(request, response);
                break;
        }
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        int shipmentId = Integer.parseInt(request.getParameter("shipmentId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        OrderItem orderItem = new OrderItem(userId, productId, quantity);
        orderItemService.save(orderItem);
        Order order = new Order(userId, paymentId, shipmentId);
        orderService.save(order);
        try {
            response.sendRedirect("/order");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        orderService.delete(id);
        try {
            response.sendRedirect("/order");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
