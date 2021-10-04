package com.codegym.service.shipment;

import com.codegym.model.Shipment;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IShipmentService extends IGeneralService<Shipment> {
    List<Shipment> searchByName(String name);

}
