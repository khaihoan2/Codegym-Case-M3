package com.codegym.service.user;

import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.User;

import java.util.List;

public class UserService implements IUserService {
    private IUserDao userDao = new UserDao();

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user);
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
        return userDao.findByName(name);
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean deleteByName(String username) {
        return userDao.deleteByName(username);
    }

    @Override
    public boolean updateByName(String username, User user) {
        return userDao.updateByName(username, user);
    }
}
