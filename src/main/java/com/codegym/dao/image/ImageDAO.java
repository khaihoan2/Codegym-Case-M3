package com.codegym.dao.image;

import com.codegym.dao.DBConnection;
import com.codegym.model.Image;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO implements IImageDAO{

    private static final Connection CONNECTION = DBConnection.getConnection();

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
        return false;
    }

    @Override
    public boolean update(int id, Image image) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Image findById(int id) {
        return null;
    }
}
