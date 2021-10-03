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
        return PRODUCT_DAO.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return PRODUCT_DAO.delete(id);
    }

    @Override
    public Product findById(int id) {
        return PRODUCT_DAO.findById(id);
    }
}
