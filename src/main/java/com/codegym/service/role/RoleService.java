package com.codegym.service.role;

import com.codegym.dao.role.IRoleDao;
import com.codegym.dao.role.RoleDao;
import com.codegym.model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleService implements IRoleService{
    private IRoleDao roleDao = new RoleDao();

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public boolean save(Role role) {
        return false;
    }

    @Override
    public boolean update(int id, Role role) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public List<Role> getRolesByUserId(int userId) {
        return roleDao.getRolesByUserId(userId);
    }
}
