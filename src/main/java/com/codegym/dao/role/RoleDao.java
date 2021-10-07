package com.codegym.dao.role;

import com.codegym.dao.DBConnection;
import com.codegym.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements IRoleDao{
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public boolean save(Role role) {
        return false;
    }

    @Override
    public boolean update(int id, Role role) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public List<Role> getRolesByUserId(int userId) {
        List<Role> roles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select r.id, r.name\n" +
                    "from user u\n" +
                    "inner join user_role ur on u.id = ur.user_id\n" +
                    "inner join role r on ur.role_id = r.id\n" +
                    "where u.id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int roleId = resultSet.getInt("id");
                String roleName = resultSet.getString("name");
                Role role = new Role(roleId, roleName);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
