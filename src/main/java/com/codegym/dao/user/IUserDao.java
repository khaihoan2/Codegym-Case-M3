package com.codegym.dao.user;


import com.codegym.dao.IGeneralDAO;
import com.codegym.model.User;

import java.util.List;

public interface IUserDao extends IGeneralDAO<User> {
    boolean login (String username,String password);
    List<User> findByName(String name);
    boolean updateByName(String username, User user);
    boolean deleteByName(String username);

}
