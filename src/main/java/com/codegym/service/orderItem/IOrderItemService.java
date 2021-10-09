package com.codegym.service.orderItem;

import com.codegym.model.OrderItem;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IOrderItemService extends IGeneralService<OrderItem> {
    List<OrderItem> getOrderItemById(int id);
}
