package com.codegym.controller.product;

import com.codegym.model.Category;
import com.codegym.model.Discount;
import com.codegym.service.discount.DiscountService;
import com.codegym.service.discount.IDiscountService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.PortableInterceptor.DISCARDING;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiscountServlet", value = "/discounts")
public class DiscountServlet extends HttpServlet {
    private static final DiscountService DISCOUNT_SERVICE = new DiscountService();

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

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<Discount> discounts = DISCOUNT_SERVICE.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/discount/list.jsp");
        request.setAttribute("discounts", discounts);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Discount discount = DISCOUNT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (discount == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("category/edit.jsp");
            request.setAttribute("discount", discount);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Discount discount = DISCOUNT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (discount == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("discount/view.jsp");
        }
        request.setAttribute("discount", discount);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Discount discount = DISCOUNT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (discount == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("discount/delete.jsp");
            request.setAttribute("discount", discount);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/category/create.jsp");
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
                createDiscount(request, response);
                break;
            }
            case "edit": {
                editDiscount(request, response);
                break;
            }
            case "delete": {
                deleteDiscount(request, response);
                break;
            }
        }
    }

    private void deleteDiscount(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDeleted = DISCOUNT_SERVICE.delete(id);
        String message = (isDeleted) ? "Discount deleted successfully!" : "Discount deleted fail!";
        request.setAttribute("message", message);
        try {
            response.sendRedirect("/discounts");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editDiscount(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int percentage = Integer.parseInt(request.getParameter("percentage"));
        Discount discount = new Discount(percentage);
        boolean isEdited = DISCOUNT_SERVICE.update(id, discount);

        String message = (isEdited) ? "Discount edited successfully!" : "Discount edited fail!";
        request.setAttribute("message", message);
        try {
            response.sendRedirect("/discounts");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDiscount(HttpServletRequest request, HttpServletResponse response) {
        int percentage = Integer.parseInt(request.getParameter("percentage"));
        Discount discount = new Discount(percentage);

        boolean isSaved = DISCOUNT_SERVICE.save(discount);

        String message = (isSaved) ? "Discount create successfully!" : "Discount created fail!";

        request.setAttribute("message", message);
        try {
            response.sendRedirect("/discounts");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
