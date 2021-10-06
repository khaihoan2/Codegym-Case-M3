package com.codegym.service.order;

import com.codegym.dao.order.IOrderDao;
import com.codegym.dao.order.OrderDao;
import com.codegym.model.Order;

import java.util.List;

public class OrderService implements IOrderService {
    private IOrderDao orderDao = new OrderDao();

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public boolean save(Order order) {
        return orderDao.save(order);
    }

    @Override
    public boolean update(int id, Order order) {
        return orderDao.update(id, order);
    }

    @Override
    public boolean delete(int id) {
        return orderDao.delete(id);
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> findByName(String name) {
        name = "%" + name + "%";
        return orderDao.findByName(name);
    }

    @Override
    public int getMaxId() {
        return orderDao.getMaxId();
    }


}
