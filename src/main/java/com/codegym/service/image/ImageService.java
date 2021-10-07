package com.codegym.service.image;

import com.codegym.dao.image.IImageDAO;
import com.codegym.dao.image.ImageDAO;
import com.codegym.model.Image;

import java.util.List;

public class ImageService implements IImageService{

    private static final IImageDAO IMAGE_DAO = new ImageDAO();

    @Override
    public List<Image> getAll() {
        return IMAGE_DAO.getAll();
    }

    @Override
    public boolean save(Image image) {
        return IMAGE_DAO.save(image);
    }

    @Override
    public boolean update(int id, Image image) {
        return IMAGE_DAO.update(id, image);
    }

    @Override
    public boolean delete(int id) {
        return IMAGE_DAO.delete(id);
    }

    @Override
    public Image findById(int id) {
        return IMAGE_DAO.findById(id);
    }

    @Override
    public List<Image> findImageByProductId(int productId) {
        return IMAGE_DAO.findImagesByProductId(productId);
    }
}
