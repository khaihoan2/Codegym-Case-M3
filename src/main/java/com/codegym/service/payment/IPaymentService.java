package com.codegym.service.payment;

import com.codegym.model.Payment;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IPaymentService extends IGeneralService<Payment> {
    List<Payment> searchByName(String name);
}
