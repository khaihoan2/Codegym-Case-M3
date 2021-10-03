package com.codegym.dao.payment;

import com.codegym.dao.DBConnection;
import com.codegym.model.Payment;

import java.sql.Connection;
import java.util.List;

public class PaymentDao implements IPaymentDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public boolean save(Payment payment) {
        return false;
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
