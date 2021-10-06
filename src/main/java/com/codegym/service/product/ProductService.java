package com.codegym.service.product;

import com.codegym.dao.brand.BrandDAO;
import com.codegym.dao.brand.IBrandDAO;
import com.codegym.dao.category.CategoryDAO;
import com.codegym.dao.category.ICategoryDAO;
import com.codegym.dao.discount.DiscountDAO;
import com.codegym.dao.discount.IDiscountDAO;
import com.codegym.dao.product.IProductDAO;
import com.codegym.dao.product.ProductDAO;
import com.codegym.dao.vendor.IVendorDAO;
import com.codegym.dao.vendor.VendorDAO;
import com.codegym.model.*;

import java.util.List;

public class ProductService implements IProductService{

    private static final IProductDAO PRODUCT_DAO = new ProductDAO();
    private static final IBrandDAO BRAND_DAO = new BrandDAO();
    private static final ICategoryDAO CATEGORY_DAO = new CategoryDAO();
    private static final IVendorDAO VENDOR_DAO = new VendorDAO();
    private static final IDiscountDAO DISCOUNT_DAO = new DiscountDAO();

    @Override
    public List<Product> getAll() {
        List<Product> products = PRODUCT_DAO.getAll();
        for (Product product : products) {
            Brand brand = BRAND_DAO.findById(product.getBrandId());
            Category category = CATEGORY_DAO.findById(product.getCategoryId());
            Vendor vendor = VENDOR_DAO.findById(product.getVendorId());
            Discount discount = DISCOUNT_DAO.findById(product.getDiscountId());
            product.setBrand(brand);
            product.setCategory(category);
            product.setVendor(vendor);
            product.setDiscount(discount);
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        return PRODUCT_DAO.save(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return PRODUCT_DAO.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return PRODUCT_DAO.delete(id);

    }

    @Override
    public Product findById(int id) {
        Product product = PRODUCT_DAO.findById(id);
        product.setBrand(BRAND_DAO.findById(product.getBrandId()));
        product.setCategory(CATEGORY_DAO.findById(product.getCategoryId()));
        product.setVendor(VENDOR_DAO.findById(product.getVendorId()));
        product.setDiscount(DISCOUNT_DAO.findById(product.getDiscountId()));
        return product;
    }
}
