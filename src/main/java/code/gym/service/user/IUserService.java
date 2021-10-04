package code.gym.service.user;

import code.gym.model.User;
import code.gym.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {

    boolean Login(String username, String password);
    boolean checkLogin(User user);
}
