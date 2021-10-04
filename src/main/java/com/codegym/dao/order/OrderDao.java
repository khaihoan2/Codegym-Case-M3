package com.codegym.dao.order;

import com.codegym.dao.DBConnection;
import com.codegym.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                    "from `order` o\n" +
                    "left join user u on o.user_id = u.id\n" +
                    "left join payment p on o.payment_id = p.id\n" +
                    "left join shipment s on o.shipment_id = s.id\n" +
                    "left join status s2 on o.status_id = s2.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("o.id");
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("username");
                int paymentId = resultSet.getInt("payment_id");
                String paymentName = resultSet.getString("p.name");
                int shipmentId = resultSet.getInt("shipment_id");
                String shipmentName = resultSet.getString("s.name");
                int statusId = resultSet.getInt("status_id");
                String statusName = resultSet.getString("s2.name");
                Date createAt = resultSet.getDate("o.created_at");
                Date lastModifiedAt = resultSet.getDate("o.last_modified_at");
                Date deleteAt = resultSet.getDate("o.delete_at");
                Order order = new Order(id, userId, userName, paymentId, paymentName, shipmentId, shipmentName, statusId, statusName, createAt, lastModifiedAt, deleteAt);
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean save(Order order) {
        boolean isSave = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into `order`(user_id, payment_id, shipment_id, status_id, created_at)\n" +
                    "value (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setInt(2, order.getPaymentId());
            preparedStatement.setInt(3, order.getShipmentId());
            preparedStatement.setInt(4, 1);
            preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
            isSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSave;
    }

    @Override
    public boolean update(int id, Order order) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        boolean isRemove = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from `order` where id = ?");
            preparedStatement.setInt(1, id);
            isRemove = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemove;
    }

    @Override
    public Order findById(int id) {
        return null;
    }
}
