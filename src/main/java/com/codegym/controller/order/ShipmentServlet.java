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
            case "edit":
                editShipment(request, response);
                break;
            default:
                showList(request, response);
                break;
        }

    }

    private void editShipment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Shipment shipment = shipmentService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shipment/create/jsp");



    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Shipment> shipments = shipmentService.getAll();
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

    }
}
