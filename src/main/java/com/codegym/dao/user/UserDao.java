package com.codegym.dao.user;

import com.codegym.dao.DBConnection;
import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement =connection.prepareStatement("select * from  user ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                Date created_at=new Date(System.currentTimeMillis());
                User user= new User(id,username,password,firstname,lastname,address,telephone,email,created_at);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
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
        boolean isUpdate=false;
        try {
            PreparedStatement statement = connection.prepareStatement("update user set username =? ,password=?,first_name=?,last_name=?,address=?,telephone=?,email=?,last_modified_at=? where id=? ");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getTelephone());
            statement.setString(7, user.getEmail());
            statement.setDate(8, new Date(System.currentTimeMillis()));
            statement.setInt(9,id);
           isUpdate= statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(int id) {
       boolean isDelete=false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from user where id = (?)");
            statement.setInt(1,id);
            isDelete= statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete ;
    }

    @Override
    public User findById(int id) {
        User users = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("select id from user where id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                Date created_at=new Date(System.currentTimeMillis());
                 users= new User(id,username,password,firstname,lastname,address,telephone,email,created_at);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users ;
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
