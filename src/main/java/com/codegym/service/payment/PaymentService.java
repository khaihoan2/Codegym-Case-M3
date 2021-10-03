package com.codegym.service.payment;

import com.codegym.model.Payment;

import java.util.List;

public class PaymentService implements IPaymentService {


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
