package code.gym.Dao.user;

import code.gym.Dao.IGeneralDao;
import code.gym.model.User;

public interface IUserDao extends IGeneralDao<User> {
    boolean Login(String username, String password);

}
