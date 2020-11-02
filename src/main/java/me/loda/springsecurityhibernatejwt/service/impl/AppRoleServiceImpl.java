package me.loda.springsecurityhibernatejwt.service.impl;


import me.loda.springsecurityhibernatejwt.Repository.IAppRoleRepository;
import me.loda.springsecurityhibernatejwt.model.AppRole;
import me.loda.springsecurityhibernatejwt.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements IAppRoleService {
    @Autowired
    private IAppRoleRepository roleRepository;
    @Override
    public Iterable<AppRole> getAllRole() {
        return roleRepository.findAll();
    }

    public AppRole getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public AppRole save(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(AppRole role) {
        roleRepository.delete(role);
    }

    @Override
    public AppRole getRoleByName(String roleName) {
        return roleRepository.getAppRoleByName(roleName);
    }
}
