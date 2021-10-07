package com.codegym.controller.product;

import com.codegym.model.Brand;
import com.codegym.model.Category;
import com.codegym.model.Shipment;
import com.codegym.service.brand.BrandService;
import com.codegym.service.brand.IBrandService;
//import sun.plugin.com.Dispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BrandServlet", value = "/brands")
public class BrandServlet extends HttpServlet {

    private static final BrandService BRAND_SERVICE = new BrandService();
    private IBrandService brandService = new BrandService();

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
            case "q":
                showListForm(request, response);
                break;
            default: {
                showListForm(request, response);
                break;
            }
        }

    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = BRAND_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (brand == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/brand/list.jsp");
        }
        request.setAttribute("brand", brand);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<Brand> brands = null;
        String name = request.getParameter("name");
        if (name == null) {
            brands = brandService.getAll();
        } else  if (name.equals("")){
            brands = null;
        } else {
            brands = brandService.searchByName(name);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand/list.jsp");
        request.setAttribute("brands", brands);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = BRAND_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (brand == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            dispatcher = request.getRequestDispatcher("brand/delete.jsp");
            request.setAttribute("brand", brand);
        }
        try {
            dispatcher.forward(request, response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = BRAND_SERVICE.findById(id);
        RequestDispatcher dispatcher;
        if (brand == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            dispatcher = request.getRequestDispatcher("brand/edit.jsp");
            request.setAttribute("brand", brand);
        }
        try {
            dispatcher.forward(request, response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/brand/create.jsp");
        try {
            dispatcher.forward(request, response);
        }catch (ServletException| IOException e){
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
                createBrand(request, response);
                break;
            }
            case "edit": {
                editBrand(request, response);
                break;
            }
            case "delete": {
                deleteBrand(request, response);
                break;
            }

        }
    }

    private void deleteBrand(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        BRAND_SERVICE.delete(id);
        try {
            response.sendRedirect("/brands");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editBrand(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Brand brand = new Brand(name);
        BRAND_SERVICE.update(id, brand);
    }

    private void createBrand(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Brand brand = new Brand(name);
        boolean isSaved = BRAND_SERVICE.save(brand);
        String message = (isSaved)? "Successful!" : "Failed!";
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/brand/create.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
