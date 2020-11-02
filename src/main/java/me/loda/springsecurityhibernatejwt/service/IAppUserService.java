package me.loda.springsecurityhibernatejwt.service;


import me.loda.springsecurityhibernatejwt.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IAppUserService {
    List<AppUser> getAllUser();
    Optional<AppUser> getUserById(Long id);
    AppUser save(AppUser user);
    void remove(AppUser user);
    AppUser getUserByUserName(String userName);
    boolean existsAppUserByUsername(String userName);
    AppUser findTopByOrderByIdDesc();
    UserDetails loadUserDetailById(Long id);
}
