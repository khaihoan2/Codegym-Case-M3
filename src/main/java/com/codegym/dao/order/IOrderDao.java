package com.codegym.dao.order;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Order;

import java.util.List;

public interface IOrderDao extends IGeneralDAO<Order> {
    List<Order> findByName(String name);

    int getMaxId();

    List<Order> getOrdersByUserId(int userId);
}
