package com.demoangularspring.angular_spring.controller;


import com.demoangularspring.angular_spring.model.AppUser;
import com.demoangularspring.angular_spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({"/users"})
@RestController
public class UserController {
    @Autowired
    IUserService userService;


    @GetMapping()
    public Iterable<AppUser> showListUser() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public AppUser showUserDetail(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser appUser){
        return userService.save(appUser);
    }

    @PutMapping("/{id}")
    public AppUser updateUser(@RequestBody AppUser appUser){
        return userService.save(appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        AppUser currentUser = userService.findById(id);
        userService.remove(currentUser);
    }


}
