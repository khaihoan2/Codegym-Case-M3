package com.codegym.service.shipment;

import com.codegym.dao.shipment.IShipmentDao;
import com.codegym.dao.shipment.ShipmentDao;
import com.codegym.model.Shipment;

import java.util.List;

public class ShipmentService implements IShipmentService {
    private IShipmentDao shipmentDao = new ShipmentDao();

    @Override
    public List<Shipment> getAll() {
        return shipmentDao.getAll();
    }

    @Override
    public boolean save(Shipment shipment) {
        return false;
    }

    @Override
    public boolean update(int id, Shipment shipment) {
        return shipmentDao.update(id, shipment);
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Shipment findById(int id) {
        return shipmentDao.findById(id);
    }
}
