package me.loda.springsecurityhibernatejwt.service.impl;


import me.loda.springsecurityhibernatejwt.Repository.IAppRoleRepository;
import me.loda.springsecurityhibernatejwt.Repository.IAppUserRepository;
import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.service.IAppUserService;
import me.loda.springsecurityhibernatejwt.jwt.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppUserServiceImpl implements UserDetailsService, IAppUserService {
    @Autowired
    private IAppUserRepository userRepository;
    @Autowired
    private IAppRoleRepository roleRepository;

    @Override
    public List<AppUser> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public Optional<AppUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(AppUser user) {
        userRepository.delete(user);
    }

    @Override
    public AppUser getUserByUserName(String userName) {
        return userRepository.findAppUserByUsername(userName);
    }

    @Override
    public boolean existsAppUserByUsername(String userName) {
        return userRepository.existsAppUserByUsername(userName);
    }

    @Override
    public AppUser findTopByOrderByIdDesc() {
        return userRepository.findTopByOrderByIdDesc();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findAppUserByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(appUser);
    }

    public UserDetails loadUserDetailById(Long id) {
        AppUser appUser = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(appUser);
    }
}
