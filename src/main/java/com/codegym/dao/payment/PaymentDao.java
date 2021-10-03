package com.codegym.dao.payment;

import com.codegym.dao.DBConnection;
import com.codegym.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao implements IPaymentDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Payment> getAll() {
        List<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from payment");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Payment payment = new Payment(id, name);
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public boolean save(Payment payment) {
        boolean isSave = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into payment(name) value (?)");
            preparedStatement.setString(1, payment.getName());
            isSave = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSave;
    }

    @Override
    public boolean update(int id, Payment payment) {
        boolean isUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update payment set name = ? where id = ?");
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, payment.getName());
            isUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdate;
    }

    @Override
    public boolean remove(int id) {
        boolean isRemove = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_payment_by_id(?)");
            callableStatement.setInt(1, id);
            isRemove = callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemove;
    }

    @Override
    public Payment findById(int id) {
        Payment payment = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from payment where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                payment = new Payment(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public List<Payment> searchByName(String name) {
        List<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from payment where name like ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                Payment payment = new Payment(id, name1);
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
