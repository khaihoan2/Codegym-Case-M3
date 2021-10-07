package com.codegym.dao.discount;

import com.codegym.dao.DBConnection;
import com.codegym.model.Discount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountDAO implements IDiscountDAO {

    private static final Connection CONNECTION = DBConnection.getConnection();

    @Override
    public List<Discount> getAll() {
        List<Discount> discounts = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM discount;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int percentage = resultSet.getInt("percentage");
                Discount discount = new Discount(id, percentage);
                discounts.add(discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discounts;
    }

    @Override
    public boolean save(Discount discount) {
        boolean isSaved = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO discount (name) VALUES (?);");
            statement.setInt(1, discount.getPercentage());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Discount discount) {
        boolean isUpdated = false;
        PreparedStatement statement = null;
        try {
            statement = CONNECTION.prepareStatement("UPDATE discount SET percentage=? WHERE id=?;");
            statement.setInt(1, discount.getPercentage());
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
            CallableStatement statement = CONNECTION.prepareCall("DELETE FROM discount WHERE id=?;");
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Discount findById(int id) {
        Discount discount = null;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM discount WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int percentage = resultSet.getInt("percentage");
                discount = new Discount(id, percentage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }
}