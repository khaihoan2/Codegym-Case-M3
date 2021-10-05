package com.codegym.service.brand;

import com.codegym.dao.brand.BrandDAO;
import com.codegym.dao.brand.IBrandDAO;
import com.codegym.model.Brand;

import java.util.List;

public class BrandService implements IBrandService{

    private static final IBrandDAO BRAND_DAO = new BrandDAO();

    @Override
    public List<Brand> getAll() {
        return BRAND_DAO.getAll();
    }

    @Override
    public boolean save(Brand brand) {
        return BRAND_DAO.save(brand);
    }

    @Override
    public boolean update(int id, Brand brand) {
        return BRAND_DAO.update(id, brand);
    }

    @Override
    public boolean delete(int id) {
        return BRAND_DAO.delete(id);
    }

    @Override
    public Brand findById(int id) {
        return BRAND_DAO.findById(id);
    }
}
