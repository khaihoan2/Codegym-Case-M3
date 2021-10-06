package com.codegym.controller.product;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private static final IProductService PRODUCT_SERVICE = new ProductService();
    public static final String ERROR_404_JSP = "error-404.jsp";
    public static final String PRODUCT_EDIT_JSP = "/product/edit.jsp";
    public static final String PRODUCT_VIEW_JSP = "/product/view.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showCreateFrom(request, response);
                break;
            }
            case "view": {
                showViewFrom(request, response);
                break;
            }
            case "edit": {
                showUpdateFrom(request, response);
                break;
            }
            case "delete": {
                showDeleteFrom(request, response);
                break;
            }
            default: {
                listAllProduct(request, response);
                break;
            }
        }
    }

    private void showViewFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = PRODUCT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(ERROR_404_JSP);
        } else {
            dispatcher = request.getRequestDispatcher(PRODUCT_VIEW_JSP);
            request.setAttribute("product", product);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = PRODUCT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher(ERROR_404_JSP);
        } else {
            dispatcher = request.getRequestDispatcher(PRODUCT_EDIT_JSP);
            request.setAttribute("product", product);
//            request.setAttribute("brands", brands);
//            request.setAttribute("categories", categories);
//            request.setAttribute("vendors", vendors);
//            request.setAttribute("discounts", discounts);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        //localhost:8080?action=delete&id=1
        int id = Integer.parseInt(request.getParameter("id"));
        Product oldProduct = PRODUCT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (oldProduct == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
            request.setAttribute("product", oldProduct);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                creatProduct(request, response);
                break;
            }
            case "update": {
                updateProduct(request, response);
                break;
            }
            case "delete": {
                deleteProduct(request, response);
                break;
            }
        }
    }

    private void creatProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String SKU = request.getParameter("SKU");
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int vendorId = Integer.parseInt(request.getParameter("vendorId"));
        int discountId = Integer.parseInt(request.getParameter("discountId"));
        Product product = new Product(name, description, price, SKU, brandId, categoryId, vendorId, discountId);
        product.setCreatedAt(LocalDate.now());
        boolean isSaved = PRODUCT_SERVICE.save(product);

        String message = (isSaved)? "Product created successfully!" : "Product created fail!";

        request.setAttribute("message", message);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("double"));
        String SKU = request.getParameter("SKU");
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int vendorId = Integer.parseInt(request.getParameter("vendorId"));
        int discountId = Integer.parseInt(request.getParameter("discountId"));
        Product product = new Product(name, description, price, SKU, brandId, categoryId, vendorId, discountId);
        product.setLastModifiedAt(LocalDate.now());
        boolean isUpdated = PRODUCT_SERVICE.update(id, product);

        String message = (isUpdated)? "Product updated successfully!" : "Product updated fail!";

        request.setAttribute("message", message);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDeleted = PRODUCT_SERVICE.delete(id);

        String message = (isDeleted)? "Product deleted successfully!" : "Product deleted fail!";

        request.setAttribute("message", message);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
