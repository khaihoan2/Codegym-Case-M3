package com.codegym.dao.payment;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Payment;

import java.util.List;

public interface IPaymentDao extends IGeneralDAO<Payment> {
    List<Payment> searchByName(String name);
}
