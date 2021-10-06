package com.codegym.service.user;

import com.codegym.dao.user.IUserDao;
import com.codegym.dao.user.UserDao;
import com.codegym.model.User;

import java.util.List;

public class UserService implements IUserService{
    private IUserDao userDao = new UserDao();

    @Override
    public List<User> getAll() {
        List<User> users = userDao.getAll();
        for (User user1:users) {
            System.out.println(user1);

        }
        return users;
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
        return userDao.delete(id);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public int findIdByUser(User user) {
        return userDao.findIdByUser(user);
    }
}
