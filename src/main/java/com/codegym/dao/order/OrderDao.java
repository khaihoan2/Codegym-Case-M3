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
                    "left join status s2 on o.status_id = s2.id\n" +
                    "group by o.created_at");
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
        boolean isUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update `order` set payment_id = ?, shipment_id = ?, status_id = ?, last_modified_at = ? where id = ?");
            preparedStatement.setInt(1, order.getPaymentId());
            preparedStatement.setInt(2, order.getShipmentId());
            preparedStatement.setInt(3, order.getStatusId());
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
            preparedStatement.setInt(5, id);
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
            CallableStatement callableStatement = connection.prepareCall("call delete_order_by_id(?)");
            callableStatement.setInt(1, id);
            isRemove = callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemove;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                    "from `order` o\n" +
                    "left join user u on o.user_id = u.id\n" +
                    "left join payment p on o.payment_id = p.id\n" +
                    "left join shipment s on o.shipment_id = s.id\n" +
                    "left join status s2 on o.status_id = s2.id\n" +
                    "where o.id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                order = new Order(id, userId, userName, paymentId, paymentName, shipmentId, shipmentName, statusId, statusName,createAt, lastModifiedAt, deleteAt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findByName(String name) {
        List<Order> orders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                    "from `order` o\n" +
                    "left join user u on o.user_id = u.id\n" +
                    "left join payment p on o.payment_id = p.id\n" +
                    "left join shipment s on o.shipment_id = s.id\n" +
                    "left join status s2 on o.status_id = s2.id\n" +
                    "left join ordered_item oi on o.id = oi.order_id\n" +
                    "where username like ?");

            preparedStatement.setString(1, name);
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
    public int getMaxId() {
        int maxId = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select max(id) maxId from `order`");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                maxId = resultSet.getInt("maxId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                "from `order` o\n" +
                "left join user u on o.user_id = u.id\n" +
                "left join payment p on o.payment_id = p.id\n" +
                "left join shipment s on o.shipment_id = s.id\n" +
                "left join status s2 on o.status_id = s2.id\n" +
                "left join ordered_item oi on o.id = oi.order_id\n" +
                "where o.user_id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("o.id");
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
}
