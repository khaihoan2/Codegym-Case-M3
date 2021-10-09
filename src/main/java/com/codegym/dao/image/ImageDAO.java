package com.codegym.dao.image;

import com.codegym.dao.DBConnection;
import com.codegym.model.Image;
import com.codegym.model.Product;

import javax.xml.transform.Result;
import java.awt.image.ImagingOpException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO implements IImageDAO {

    private static final Connection CONNECTION = DBConnection.getConnection();
    public static final String SQL_INSERT = "INSERT INTO image (name, image_object, productID) VALUES (?,?,?)";
    public static final String SQL_DELETE = "DELETE FROM image WHERE id = ?";
    public static final String SQL_FIND_BY_ID = "SELECT * FROM image WHERE id = ?";

    @Override
    public List<Image> getAll() {
        List<Image> images = new ArrayList<>();
        try {
            CallableStatement statement = CONNECTION.prepareCall("CALL get_product_image();");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String src = resultSet.getString("src");
                int productId = resultSet.getInt("product_id");
                Image image = new Image(id, name, src, productId);
                images.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    public boolean save(Image image) {
        boolean isSaved = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_INSERT);
            InputStream imageObject = new FileInputStream(image.getSrc());
            statement.setString(1, image.getName());
            statement.setBlob(2, imageObject);
            statement.setInt(3, image.getProductId());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Image image) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_DELETE);
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Image findById(int inputId) {
        Image image = null;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, inputId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String src = resultSet.getString("src");
                int productId = resultSet.getInt("productId");
                image = new Image(id, name, src, productId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public List<Image> findImagesByProductId(int productId) {
        List<Image> images = new ArrayList<>();
        try {
            CallableStatement statement = CONNECTION.prepareCall("CALL get_images_by_product_id(?)");
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String src = resultSet.getString("src");
                Image image = new Image(id, name, src, productId);
                images.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }
}
