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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shipment");
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
        boolean isShipment = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shipment(name) VALUE (?)");
            preparedStatement.setString(1, shipment.getName());
            isShipment = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isShipment;
    }

    @Override
    public boolean update(int id, Shipment shipment) {
        boolean isUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shipment SET name = ? WHERE id = ?");
            preparedStatement.setString(1, shipment.getName());
            preparedStatement.setInt(2, id);
            isUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean isRemove = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL delete_shipment_by_id(?)");
            callableStatement.setInt(1, id);
            isRemove = callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemove;
    }

    @Override
    public Shipment findById(int id) {
        Shipment shipment = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shipment WHERE id = ?");
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

    @Override
    public List<Shipment> searchByName(String name) {
        List<Shipment> shipments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shipment WHERE name LIKE ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                Shipment shipment = new Shipment(id, name1);
                shipments.add(shipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shipments;
    }
}
