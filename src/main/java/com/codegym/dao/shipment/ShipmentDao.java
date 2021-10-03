package com.codegym.dao.shipment;

import com.codegym.dao.DBConnection;
import com.codegym.model.Shipment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipmentDao implements IShipmentDao {
    private Connection connection = DBConnection.getConnection();


    @Override
    public List<Shipment> getAll() {
        List<Shipment> shipments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shipment");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Shipment shipment = new Shipment(id, name);
                shipments.add(shipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipments;
    }

    @Override
    public boolean save(Shipment shipment) {
        return false;
    }

    @Override
    public boolean update(int id, Shipment shipment) {
        boolean isUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update shipment set name = ? where id = ?");
            preparedStatement.setString(1, shipment.getName());
            preparedStatement.setInt(2, id);
            isUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Shipment findById(int id) {
        Shipment shipment = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shipment where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                shipment = new Shipment(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipment;
    }
}
