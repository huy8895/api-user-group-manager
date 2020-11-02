package me.loda.springsecurityhibernatejwt.service;


import me.loda.springsecurityhibernatejwt.model.AppRole;

public interface IAppRoleService {
    Iterable<AppRole> getAllRole();
    AppRole getRoleById(Long id);
    AppRole save(AppRole role);
    void remove(AppRole role);
    AppRole getRoleByName(String roleName);
}
