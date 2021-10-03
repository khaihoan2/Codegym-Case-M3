package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{

    private static final Connection CONNECTION = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = Double.parseDouble(resultSet.getString("price"));
                String SKU = resultSet.getString("SKU");
                int brandId = resultSet.getInt("brand_id");
                int categoryId = resultSet.getInt("category_id");
                int vendorId = resultSet.getInt("vendor_id");
                int discountId = resultSet.getInt("discount_id");
                LocalDate createAt = LocalDate.parse(resultSet.getString("created_at"));
                LocalDate lastModifiedAt = LocalDate.parse(resultSet.getString("created_at"));
                LocalDate deletedAt = LocalDate.parse(resultSet.getString("created_at"));
                Product product = new Product(id, name, description, price, SKU, brandId, categoryId, vendorId, discountId, createAt, lastModifiedAt, deletedAt);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        return false;
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
