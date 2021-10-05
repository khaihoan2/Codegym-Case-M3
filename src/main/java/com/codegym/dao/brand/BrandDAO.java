package com.codegym.dao.brand;

import com.codegym.dao.DBConnection;
import com.codegym.model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements IBrandDAO {

    private static final Connection CONNECTION = DBConnection.getConnection();

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT  * FROM brand;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Brand brand = new Brand(id, name);
                brands.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public boolean save(Brand brand) {
        boolean isSaved = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO brand (name) VALUES (?);");
            statement.setString(1, brand.getName());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Brand brand) {
        boolean isUpdated = false;
        PreparedStatement statement = null;
        try {
            statement = CONNECTION.prepareStatement("UPDATE brand SET name=? WHERE id=?");
            statement.setString(1, brand.getName());
            statement.setInt(2, id);
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
            PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM brand WHERE id=?");
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Brand findById(int id) {
        Brand brand = null;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM brand WHERE id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                brand = new Brand(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }
}