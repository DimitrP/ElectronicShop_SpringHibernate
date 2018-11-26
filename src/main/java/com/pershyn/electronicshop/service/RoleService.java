package com.pershyn.electronicshop.service;


import com.pershyn.electronicshop.model.Role;

import java.util.Set;

public interface RoleService {

    public Role getRoleByName(String name);

    public Role getRoleById(Integer id);

    public Set<Role> getAllRoles();
}
