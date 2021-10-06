package com.codegym.controller.product;

import com.codegym.service.vendor.IVendorService;
import com.codegym.service.vendor.VendorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
                showCreate(request, response);
                break;
            }
            case"delete":{
                showDelete(request, response);
                break;
            }
            default: {
                showList(request, response);
                break;
            }
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCreate(request, response);
                break;
            }
            case "delete":{
                showDelete(request, response);
            }
            default: {
                listBrand(request, response);
                break;
            }
        }
    }

    private void listBrand(HttpServletRequest request, HttpServletResponse response) {
    }
}
