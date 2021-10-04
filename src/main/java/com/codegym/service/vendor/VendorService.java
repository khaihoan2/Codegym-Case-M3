package com.codegym.service.vendor;

import com.codegym.dao.vendor.IVendorDAO;
import com.codegym.dao.vendor.VendorDAO;
import com.codegym.model.Vendor;

import java.util.List;

public class VendorService implements IVendorService {

    private static final IVendorDAO VENDOR_DAO = new VendorDAO();

    @Override
    public List<Vendor> getAll() {
        return VENDOR_DAO.getAll();
    }

    @Override
    public boolean save(Vendor vendor) {
        return VENDOR_DAO.save(vendor);
    }

    @Override
    public boolean update(int id, Vendor vendor) {
        return VENDOR_DAO.update(id, vendor);
    }

    @Override
    public boolean delete(int id) {
        return VENDOR_DAO.delete(id);
    }

    @Override
    public Vendor findById(int id) {
        return VENDOR_DAO.findById(id);
    }
}
