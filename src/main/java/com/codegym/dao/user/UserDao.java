package com.codegym.dao.user;

import com.codegym.dao.DBConnection;
import com.codegym.model.User;

import java.sql.*;
import java.util.List;

public class UserDao implements IUserDao{
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        boolean isSave = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(username, password, first_name, last_name, address, telephone, email, created_at)\n" +
                    "value (?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getTelephone());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setDate(8, new Date(System.currentTimeMillis()));
            isSave = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    @Override
    public boolean update(int id, User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public int findIdByUser(User user) {
        int id = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id from user where username = ? and password = ?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
