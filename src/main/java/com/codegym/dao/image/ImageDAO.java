package com.codegym.dao.image;

import com.codegym.dao.DBConnection;
import com.codegym.model.Image;
import com.codegym.model.Product;

import javax.xml.transform.Result;
import java.awt.image.ImagingOpException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO implements IImageDAO{

    private static final Connection CONNECTION = DBConnection.getConnection();
    public static final String SQL_INSERT = "INSERT INTO image (name, src, productID) VALUES (?,?,?)";
    public static final String SQL_UPDATE = "UPDATE image\n" +
            "SET name = ?,\n" +
            "    src = ?,\n" +
            "    product_id = ?\n" +
            "WHERE id = ?";
    public static final String SQL_DELETE = "DELETE\n" +
            "  FROM image\n" +
            " WHERE id = ?";
    public static final String SQL_FIND_BY_ID = "SELECT * FROM image WHERE id = ?";

    @Override
    public List<Image> getAll() {
        List<Image> images = new ArrayList<>();
        try {
            PreparedStatement statement = CONNECTION.prepareStatement("SELECT * FROM image");
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
            statement.setString(1, image.getName());
            statement.setString(2, image.getSrc());
            statement.setInt(3, image.getProductId());
            isSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Image image) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(SQL_UPDATE);
            statement.setString(1, image.getName());
            statement.setString(2, image.getSrc());
            statement.setInt(3, image.getProductId());
            statement.setInt(4, image.getId());
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
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
            statement.setInt(1,inputId);
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
}
