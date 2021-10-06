package com.codegym.dao.user;

import com.codegym.dao.DBConnection;
import com.codegym.model.User;

import java.sql.*;
import java.sql.Date;
import java.util.List;

public class UserDao implements IUserDao {
    private static final Connection connection = DBConnection.getConnection();

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert  into user (username,password,first_name,last_name,address,telephone,email,create_at) value (?,?,?,?,?,?,?,?)");
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFirst_name());
            statement.setString(4,user.getLast_name());
            statement.setString(5,user.getFirst_name());
            statement.setString(6,user.getAddress());
            statement.setString(7,user.getTelephone());
            statement.setDate(8,new Date(System.currentTimeMillis()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
}
