package com.codegym.service.discount;

import com.codegym.dao.discount.DiscountDAO;
import com.codegym.dao.discount.IDiscountDAO;
import com.codegym.model.Discount;

import java.util.List;

public class DiscountService implements IDiscountService{

    private static final IDiscountDAO DISCOUNT_DAO = new DiscountDAO();

    @Override
    public List<Discount> getAll() {
        return DISCOUNT_DAO.getAll();
    }

    @Override
    public boolean save(Discount discount) {
        return DISCOUNT_DAO.save(discount);
    }

    @Override
    public boolean update(int id, Discount discount) {
        return DISCOUNT_DAO.update(id, discount);
    }

    @Override
    public boolean delete(int id) {
        return DISCOUNT_DAO.delete(id);
    }

    @Override
    public Discount findById(int id) {
        return DISCOUNT_DAO.findById(id);
    }
}