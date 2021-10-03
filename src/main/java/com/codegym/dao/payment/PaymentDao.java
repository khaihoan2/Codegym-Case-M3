package com.codegym.dao.payment;

import com.codegym.dao.DBConnection;
import com.codegym.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Payment findById(int id) {
        return null;
    }
}
