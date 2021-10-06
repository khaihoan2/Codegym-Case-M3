package com.codegym.controller.product;

import com.codegym.model.Category;
import com.codegym.model.Discount;
import com.codegym.service.discount.DiscountService;
import com.codegym.service.discount.IDiscountService;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {
    private static final DiscountService DISCOUNT_SERVICE = new DiscountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "Create": {
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
            case"delete":  {
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
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Discount discount = DISCOUNT_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (discount == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            dispatcher = request.getRequestDispatcher("category/edit.jsp");
            request.setAttribute("discount", discount);
        }
        try {
            dispatcher.forward(request, response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }


    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
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
            case "Create": {
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
    }

    private void editDiscount(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createDiscount(HttpServletRequest request, HttpServletResponse response) {
    }
}
