package me.loda.springsecurityhibernatejwt.Repository;


import me.loda.springsecurityhibernatejwt.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole getAppRoleByName (String roleName);
}
