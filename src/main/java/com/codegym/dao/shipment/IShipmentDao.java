package com.codegym.dao.shipment;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Shipment;

import java.util.List;

public interface IShipmentDao extends IGeneralDao<Shipment> {
    List<Shipment> searchByName(String name);

}
