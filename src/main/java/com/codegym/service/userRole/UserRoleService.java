package com.codegym.service.userRole;

import com.codegym.dao.userRole.IUserRoleDao;
import com.codegym.dao.userRole.UserRoleDao;
import com.codegym.model.UserRole;

import java.util.List;

public class UserRoleService implements IUserRoleService {
    private IUserRoleDao userRoleDao = new UserRoleDao();

    @Override
    public List<UserRole> getAll() {
        return null;
    }

    @Override
    public boolean save(UserRole userRole) {
        return userRoleDao.save(userRole);
    }

    @Override
    public boolean update(int id, UserRole userRole) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public UserRole findById(int id) {
        return null;
    }
}
