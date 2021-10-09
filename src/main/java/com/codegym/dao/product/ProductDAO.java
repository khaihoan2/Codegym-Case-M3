package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private static final Connection CONNECTION = DBConnection.getConnection();
    private static final String SQL_SELECT_ALL = "SELECT * FROM product;";
    public static final String SQL_UPDATE = "UPDATE product\n" +
            "   SET name             = ?,\n" +
            "       description      = ?,\n" +
            "       price            = ?,\n" +
            "       SKU              = ?,\n" +
            "       brand_id         = ?,\n" +
            "       category_id      = ?,\n" +
            "       vendor_id        = ?,\n" +
            "       discount_id      = ?\n" +
            " WHERE id = ?";
    public static final String SQL_DELETED = "DELETE FROM product WHERE id = ?";
    public static final String SQL_FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
    public static final String SQL_INSERT = "INSERT INTO product (name, description, price, SKU, brand_id, category_id, vendor_id, discount_id, created_at) " +
            "VALUES (?,?,?,?,?,?,?,?,(SELECT CURDATE()))";
    public static final String SQL_FIND_BY_NAME = "SELECT * FROM product WHERE name LIKE ?";

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_SELECT_ALL);
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
        boolean isSaved = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_INSERT);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getSKU());
            statement.setInt(5, product.getBrandId());
            statement.setInt(6, product.getCategoryId());
            statement.setInt(7, product.getVendorId());
            statement.setInt(8, product.getDiscountId());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_UPDATE);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getSKU());
            statement.setInt(5, product.getBrandId());
            statement.setInt(6, product.getCategoryId());
            statement.setInt(7, product.getVendorId());
            statement.setInt(8, product.getDiscountId());
            statement.setInt(9, id);
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_DELETED);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
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
                product = new Product(id, name, description, price, SKU, brandId, categoryId, vendorId, discountId, createAt, lastModifiedAt, deletedAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByName(String keyword) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_FIND_BY_NAME);
            statement.setString(1, keyword);
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
}