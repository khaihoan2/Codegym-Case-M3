package com.codegym.service.user;

import com.codegym.model.User;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IUserService extends IGeneralService<User> {
    boolean login(String username, String password);

    boolean deleteByName(String username);

    boolean updateByName(String username, User user);

    List<User> findByName(String name);
}
