package com.codegym.dao.category;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{

    private static final Connection CONNECTION = DBConnection.getConnection();

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM category;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean save(Category category) {
        boolean isSaved = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO category (name) VALUES (?)");
            statement.setString(1, category.getName());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Category category) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("UPDATE category SET name=? WHERE id=?");
            statement.setString(1, category.getName());
            statement.setInt(1, id);
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
            CallableStatement statement = CONNECTION.prepareCall("CALL delete_category");
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        PreparedStatement statement = null;
        try {
            statement = CONNECTION.prepareStatement("SELECT * FROM category WHERE id=?;");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}