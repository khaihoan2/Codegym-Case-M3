package com.codegym.dao.image;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Image;

import java.util.List;

public interface IImageDAO extends IGeneralDAO<Image> {
    List<Image> findImagesByProductId(int productId);
}
