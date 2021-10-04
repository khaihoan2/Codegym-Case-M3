package com.codegym.dao.orderItem;

import com.codegym.dao.DBConnection;
import com.codegym.model.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDao implements IOrderItemDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<OrderItem> getAll() {


        return null;
    }

    @Override
    public boolean save(OrderItem orderItem) {
        boolean isSave = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ordered_item (order_id, product_id, quantity) values (?, ?, ?)");
            preparedStatement.setInt(1, orderItem.getOrderId());
            preparedStatement.setInt(2, orderItem.getProductId());
            preparedStatement.setInt(3, orderItem.getQuantity());
            isSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    @Override
    public boolean update(int id, OrderItem orderItem) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public OrderItem findById(int id) {
        return null;
    }
}
