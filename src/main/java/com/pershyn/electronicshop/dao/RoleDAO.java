package com.pershyn.electronicshop.dao;


import com.pershyn.electronicshop.model.Role;

import java.util.Set;

public interface RoleDAO {

    public Role getRoleByName(String name);

    public Role getRoleById(Integer id);

    public Set<Role> getAllRoles();
}
