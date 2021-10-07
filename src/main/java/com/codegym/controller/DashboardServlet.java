package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.brand.BrandService;
import com.codegym.service.brand.IBrandService;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.discount.DiscountService;
import com.codegym.service.discount.IDiscountService;
import com.codegym.service.order.IOrderService;
import com.codegym.service.order.OrderService;
import com.codegym.service.payment.IPaymentService;
import com.codegym.service.payment.PaymentService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;
import com.codegym.service.shipment.IShipmentService;
import com.codegym.service.shipment.ShipmentService;
import com.codegym.service.user.IUserService;
import com.codegym.service.user.UserService;
import com.codegym.service.vendor.IVendorService;
import com.codegym.service.vendor.VendorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {

    private static final IProductService PRODUCT_SERVICE = new ProductService();
    private static final ICategoryService CATEGORY_SERVICE = new CategoryService();
    private static final IBrandService BRAND_SERVICE = new BrandService();
    private static final IVendorService VENDOR_SERVICE = new VendorService();
    private static final IDiscountService DISCOUNT_SERVICE = new DiscountService();
    private static final IUserService USER_SERVICE = new UserService();
    private static final IOrderService ORDER_SERVICE = new OrderService();
    private static final IPaymentService PAYMENT_SERVICE = new PaymentService();
    private static final IShipmentService SHIPMENT_SERVICE = new ShipmentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = PRODUCT_SERVICE.getAll();
        List<Product> latestProducts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            latestProducts.add(products.get(i));
        }

        List<Category> categories = CATEGORY_SERVICE.getAll();
        List<Brand> brands = BRAND_SERVICE.getAll();
        List<Vendor> vendors = VENDOR_SERVICE.getAll();
        List<Discount> discounts = DISCOUNT_SERVICE.getAll();

        List<User> users = USER_SERVICE.getAll();
        List<User> latestMembers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            latestMembers.add(users.get(i));
        }

        List<Order> orders = ORDER_SERVICE.getAll();
        List<Order> latestOrders = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            latestOrders.add(orders.get(i));
        }

        List<Payment> payments = PAYMENT_SERVICE.getAll();
        List<Shipment> shipments = SHIPMENT_SERVICE.getAll();

        request.setAttribute("products", products);
        request.setAttribute("latestProducts", latestProducts);
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        request.setAttribute("vendors", vendors);
        request.setAttribute("discounts", discounts);
        request.setAttribute("users", users);
        request.setAttribute("latestMembers", latestMembers);
        request.setAttribute("orders", orders);
        request.setAttribute("latestOrders", latestOrders);
        request.setAttribute("payments", payments);
        request.setAttribute("shipments", shipments);

        HttpSession session = request.getSession();

        RequestDispatcher dispatcher;
        if (session.isNew()) {
            dispatcher = request.getRequestDispatcher("/login/login.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/dashboard.jsp");
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
