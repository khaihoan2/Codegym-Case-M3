package com.codegym.dao.shipment;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Shipment;

import java.util.List;

public interface IShipmentDao extends IGeneralDAO<Shipment> {
    List<Shipment> searchByName(String name);

}
