package com.codegym.dao.vendor;

import com.codegym.dao.DBConnection;
import com.codegym.model.Vendor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO implements IVendorDAO {

    private static final Connection CONNECTION = DBConnection.getConnection();

    @Override
    public List<Vendor> getAll() {
        List<Vendor> vendors = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM vendor;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Vendor vendor = new Vendor(id, name, address);
                vendors.add(vendor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendors;
    }

    @Override
    public boolean save(Vendor vendor) {
        boolean isSaved = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO vendor (name, address) VALUES (?,?);");
            statement.setString(1, vendor.getName());
            statement.setString(2, vendor.getAddress());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Vendor vendor) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("UPDATE vendor SET name=?, address=? WHERE id=?");
            statement.setString(1, vendor.getName());
            statement.setString(2, vendor.getAddress());
            statement.setInt(3, id);
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isMarkAsDeleted = false;
        try {
            CallableStatement statement = CONNECTION.prepareCall("UPDATE vendor SET delete_at = ? WHERE id=?");
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setInt(2, id);
            isMarkAsDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMarkAsDeleted;
    }

    @Override
    public Vendor findById(int id) {
        Vendor vendor = null;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM vendor WHERE id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                vendor = new Vendor(id, name, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendor;
    }
}
