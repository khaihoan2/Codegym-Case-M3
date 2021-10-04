package com.codegym.controller.order;

import com.codegym.model.Shipment;
import com.codegym.service.shipment.IShipmentService;
import com.codegym.service.shipment.ShipmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShipmentServlet", value = "/shipment")
public class ShipmentServlet extends HttpServlet {
    private IShipmentService shipmentService = new ShipmentService();

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
            case "q":
                showList(request, response);
                break;
            default:
                showList(request, response);
                break;
        }

    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shipment/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shipment/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Shipment shipment = shipmentService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shipment/edit.jsp");
        request.setAttribute("shipment", shipment);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Shipment> shipments = null;
        String name = request.getParameter("name");
        if (name == null) {
            shipments = shipmentService.getAll();
        } else  if (name.equals("")){
            shipments = null;
        } else {
            shipments = shipmentService.searchByName(name);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shipment/list.jsp");
        request.setAttribute("shipments", shipments);
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
                createShipment(request, response);
                break;
            case "edit":
                editShipment(request, response);
                break;
            case "delete":
                deleteShipment(request, response);
                break;
        }

    }

    private void deleteShipment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        shipmentService.delete(id);
        try {
            response.sendRedirect("/shipment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createShipment(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Shipment shipment = new Shipment(name);
        shipmentService.save(shipment);
        try {
            response.sendRedirect("/shipment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editShipment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Shipment shipment = new Shipment(id, name);
        shipmentService.update(id, shipment);
        try {
            response.sendRedirect("/shipment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
