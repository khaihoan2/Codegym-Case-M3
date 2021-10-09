package com.codegym.service.brand;

import com.codegym.model.Brand;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IBrandService extends IGeneralService<Brand> {
    List<Brand> searchByName(String name);
}
