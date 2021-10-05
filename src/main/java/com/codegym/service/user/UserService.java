package com.codegym.service.user;

import com.codegym.Dao.user.IUserDao;
import com.codegym.Dao.user.UserDao;
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
    public boolean update(int id, User user) {
        return userDao.update(id,user);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username,password);
    }
}
