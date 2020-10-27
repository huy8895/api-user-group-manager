package com.demoangularspring.angular_spring.service;


import com.demoangularspring.angular_spring.model.AppUser;

public interface IUserService {
    Iterable<AppUser> findAll();
    AppUser findById(Long id);
    AppUser save(AppUser appUser);
    void remove(AppUser appUser);
}

