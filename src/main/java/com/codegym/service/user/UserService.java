package com.codegym.service.user;

import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.User;
import java.util.List;

public class UserService implements IUserService {
    private IUserDao userDao = new UserDao();

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean update(String username, User user) {
        return userDao.update(username,user);
    }

    @Override
    public boolean delete(String username) {
        return userDao.delete(username);
    }

    @Override
    public List<User> findByName(String username) {
        username="%" +username+ "%";
        return userDao.findByName(username);
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username,password);
    }
}
