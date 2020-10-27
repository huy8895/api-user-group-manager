package com.demoangularspring.angular_spring.service.impl;


import com.demoangularspring.angular_spring.exception.ApiExceptionHandler;
import com.demoangularspring.angular_spring.model.AppUser;
import com.demoangularspring.angular_spring.repository.UserRepository;
import com.demoangularspring.angular_spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository UserRepository;

    @Override
    public Iterable<AppUser> findAll() {
        return UserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return UserRepository.findById(id).get();

    }

    @Override
    public AppUser save(AppUser AppUser) {
        return UserRepository.save(AppUser);
    }

    @Override
    public void remove(AppUser AppUser) {
        UserRepository.delete(AppUser);
    }
}
