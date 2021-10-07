package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EcommerceServlet", value = "/ecommerce")
public class EcommerceServlet extends HttpServlet {

    private static final IProductService PRODUCT_SERVICE = new ProductService();

    List<Product> products = PRODUCT_SERVICE.getAll();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view": {
                displayProductDetail(request, response);
                break;
            }
            case "": {
                displayStorePage(request, response);
                break;
            }
        }
    }

    private void displayProductDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product theProduct = PRODUCT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (theProduct == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("products", products);
            request.setAttribute("theProduct", theProduct);
            dispatcher = request.getRequestDispatcher("/productDetails.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayStorePage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/store.jsp");
        try {
            request.setAttribute("products", products);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
