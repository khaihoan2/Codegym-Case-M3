package com.codegym.service.role;

import com.codegym.model.Role;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IRoleService extends IGeneralService<Role> {
    List<Role> getRolesByUserId(int userId);

}
