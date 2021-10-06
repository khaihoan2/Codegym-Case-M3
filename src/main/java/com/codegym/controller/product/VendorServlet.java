package com.codegym.controller.product;

import com.codegym.model.*;
import com.codegym.service.vendor.IVendorService;
import com.codegym.service.vendor.VendorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VendorServlet", value = "/vendors")
public class VendorServlet extends HttpServlet {

    private static final IVendorService VENDOR_SERVICE = new VendorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCreateForm(request, response);
                break;
            }
            case "edit": {
                showEditForm(request, response);
                break;
            }
            case "view": {
                showViewForm(request, response);
                break;
            }
            case "delete": {
                showDeleteForm(request, response);
                break;
            }
            default: {
                showListForm(request, response);
                break;
            }
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Vendor discount = VENDOR_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (discount == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("vendor/view.jsp");
        }
        request.setAttribute("vendor", discount);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Vendor category = VENDOR_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (category == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("vendor/edit.jsp");
            request.setAttribute("vendor", category);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<Vendor> brands = VENDOR_SERVICE.getAll();
        request.setAttribute("vendors", brands);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/vendor/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Vendor brand = VENDOR_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (brand == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("vendor/delete.jsp");
            request.setAttribute("vendor", brand);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vendor/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
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
            case "create": {
                createVendor(request, response);
                break;
            }
            case "edit": {
                EditVendor(request, response);
                break;
            }
            case "delete": {
                deleteVendor(request, response);
            }
        }
    }

    private void EditVendor(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Vendor vendor = new Vendor(name);
        VENDOR_SERVICE.update(id, vendor);
    }

    private void deleteVendor(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        VENDOR_SERVICE.delete(id);
    }

    private void createVendor(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Vendor vendor = new Vendor(name);
        VENDOR_SERVICE.save(vendor);
        try {
            response.sendRedirect("/vendors");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

