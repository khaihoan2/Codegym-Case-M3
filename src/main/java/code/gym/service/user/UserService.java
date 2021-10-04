package code.gym.service.user;

import code.gym.Dao.user.IUserDao;
import code.gym.Dao.user.UserDao;
import code.gym.model.User;

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
    public boolean Login(String username, String password) {
        return userDao.Login(username, password);
    }

    @Override
    public boolean checkLogin(User user) {
        List<User> users = userDao.getAll();
        for (User user1: users) {
            if (user.getUsername().equals(user1.getUsername())){
                return false;
            }else {
            }
        }
        return false;
    }

}
