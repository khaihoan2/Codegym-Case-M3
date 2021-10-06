package com.codegym.dao.orderItem;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.OrderItem;

import java.util.List;

public interface IOrderItemDao extends IGeneralDAO<OrderItem> {
    List<OrderItem> getOrderItemById(int id);
}
