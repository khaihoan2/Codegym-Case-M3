package com.codegym.service.product;

import com.codegym.dao.product.IProductDAO;
import com.codegym.dao.product.ProductDAO;
import com.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService{

    private static final IProductDAO PRODUCT_DAO = new ProductDAO();

    @Override
    public List<Product> getAll() {
        return PRODUCT_DAO.getAll();
    }

    @Override
    public boolean save(Product product) {
        return PRODUCT_DAO.save(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
