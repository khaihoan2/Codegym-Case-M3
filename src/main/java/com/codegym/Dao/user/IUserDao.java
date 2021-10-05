package com.codegym.Dao.user;

import com.codegym.Dao.IGeneralDao;
import com.codegym.model.User;

public interface IUserDao extends IGeneralDao<User> {
    boolean login (String username,String password);
}
