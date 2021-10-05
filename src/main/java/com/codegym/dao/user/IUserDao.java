package com.codegym.dao.user;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.User;

public interface IUserDao extends IGeneralDao<User> {
    boolean login (String username,String password);
}
