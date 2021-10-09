package com.codegym.service.order;

import com.codegym.model.Order;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IOrderService extends IGeneralService<Order> {
    List<Order> findByName(String name);

    int getMaxId();

    List<Order> getOrdersByUserId(int userId);

}
