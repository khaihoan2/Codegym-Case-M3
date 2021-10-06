package com.codegym.dao.user;

import com.codegym.dao.DBConnection;
import com.codegym.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    private static final Connection connection = DBConnection.getConnection();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String first_name = resultSet.getString("first_name ");
                String last_name = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                Date created_at = resultSet.getDate("created_at");
                Date last_modified_at = resultSet.getDate("last_modified_at");
                Date delete_at = resultSet.getDate("delete_at");
                users.add(new User(id, username, password, first_name, last_name, address, telephone, email, created_at, last_modified_at, delete_at));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean save(User user) {
        boolean isCreated=false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into user (username,password,first_name,last_name,address,telephone,email,created_at) value (?,?,?,?,?,?,?,?)");
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFirst_name());
            statement.setString(4,user.getLast_name());
            statement.setString(5,user.getAddress());
            statement.setString(6,user.getTelephone());
            statement.setString(7,user.getEmail());
            statement.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
            isCreated = statement.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isCreated;
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
    public boolean updateByName(String username, User user) {
        boolean isUpdate=false;
        try {
            PreparedStatement statement = connection.prepareStatement("update user  set username=?,password=?,first_name=?,last_name=?,address=?,telephone=?,email=?,created_at=? where username=?");
            statement.setString(1,user.getUsername());
            statement.setString(1,user.getPassword());
            statement.setString(1,user.getFirst_name());
            statement.setString(1,user.getLast_name());
            statement.setString(1,user.getAddress());
            statement.setString(1,user.getTelephone());
            statement.setString(1,user.getEmail());
            statement.setDate(1,user.getCreated_at());
            isUpdate = statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean deleteByName(String username) {
        boolean isDelete=false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_by_name(?)");
            callableStatement.setString(1,username);
            isDelete=callableStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users= new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where like username = ?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()==true){
                String username=resultSet.getString("username");
                String password = resultSet.getString("password");
                String first_name = resultSet.getString("first_name ");
                String last_name = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                Date created_at = resultSet.getDate("created_at");
                User user =new User(username, password, first_name, last_name, address, telephone, email, created_at);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean login(String username, String password) {
        boolean isValid=false;
        try {

            PreparedStatement statement = connection.prepareStatement("select * from  user where username=? and  password=?");
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet =statement.executeQuery();
            if (resultSet.next()){
                isValid=true;

            }else {
                isValid=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
