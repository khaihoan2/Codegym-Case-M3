package com.codegym.controller.product;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private static final IProductService PRODUCT_SERVICE = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {

                break;
            }
            default: {
                listAllProduct(request, response);
                break;
            }
        }
    }

    private void listAllProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = PRODUCT_SERVICE.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
