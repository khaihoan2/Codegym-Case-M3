package com.codegym.service.payment;

import com.codegym.dao.payment.IPaymentDao;
import com.codegym.dao.payment.PaymentDao;
import com.codegym.model.Payment;

import java.util.List;

public class PaymentService implements IPaymentService {
    private IPaymentDao paymentDao = new PaymentDao();

    @Override
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }

    @Override
    public boolean save(Payment payment) {
        return paymentDao.save(payment);
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
