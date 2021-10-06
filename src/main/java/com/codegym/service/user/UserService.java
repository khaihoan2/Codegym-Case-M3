package com.codegym.service.user;

import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.User;

import java.util.List;

public class UserService implements IUserService {
    private static final IUserDao USER_DAO = new UserDao();

    @Override
    public List<User> getAll() {
        return USER_DAO.getAll();
    }

    @Override
    public boolean save(User user) {
        return USER_DAO.save(user);
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
    public List<User> findByName(String name) {
        name = "%" + name + "%";
        return USER_DAO.findByName(name);
    }

    @Override
    public boolean login(String username, String password) {
        List<User> users = USER_DAO.getAll();


        return true;
    }

    @Override
    public boolean deleteByName(String username) {
        return USER_DAO.deleteByName(username);
    }

    @Override
    public boolean updateByName(String username, User user) {
        return USER_DAO.updateByName(username, user);
    }
}
