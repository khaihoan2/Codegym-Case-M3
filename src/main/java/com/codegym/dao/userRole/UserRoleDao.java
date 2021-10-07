package com.codegym.dao.userRole;

import com.codegym.dao.DBConnection;
import com.codegym.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserRoleDao implements IUserRoleDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<UserRole> getAll() {
        return null;
    }

    @Override
    public boolean save(UserRole userRole) {
        boolean isSave = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user_role(user_id, role_id) value (?, ?)");
            preparedStatement.setInt(1, userRole.getUserId());
            preparedStatement.setInt(2, userRole.getRoleId());
            isSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    @Override
    public boolean update(int id, UserRole userRole) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public UserRole findById(int id) {
        return null;
    }
}
