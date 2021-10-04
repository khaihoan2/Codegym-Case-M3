package com.codegym.dao.payment;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Payment;

import java.util.List;

public interface IPaymentDao extends IGeneralDao<Payment> {
    List<Payment> searchByName(String name);
}
