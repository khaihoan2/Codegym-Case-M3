package com.codegym.dao.status;

import com.codegym.dao.DBConnection;
import com.codegym.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao implements IStatusDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Status> getAll() {
        List<Status> statuses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from status");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                statuses.add(new Status(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public boolean save(Status status) {
        return false;
    }

    @Override
    public boolean update(int id, Status status) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Status findById(int id) {
        return null;
    }
}
