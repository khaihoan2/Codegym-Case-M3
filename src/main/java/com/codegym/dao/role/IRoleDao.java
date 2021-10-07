package com.codegym.dao.role;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Role;

import java.util.List;

public interface IRoleDao extends IGeneralDAO<Role> {
    List<Role> getRolesByUserId(int userId);
}
