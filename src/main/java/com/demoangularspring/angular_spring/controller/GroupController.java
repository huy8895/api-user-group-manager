package com.demoangularspring.angular_spring.controller;

import com.demoangularspring.angular_spring.model.AppGroup;
import com.demoangularspring.angular_spring.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({"/groups"})
@RestController
public class GroupController {
    @Autowired
    IGroupService groupService;


    @GetMapping()
    public Iterable<AppGroup> getGroups() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    public AppGroup showUserDetail(@PathVariable("id") Long id) {
        return groupService.findById(id);
    }

    @PostMapping
    public AppGroup createUser(@RequestBody AppGroup appGroup) {
        return groupService.save(appGroup);
    }

    @PutMapping("/{id}")
    public AppGroup updateUser(@PathVariable("id") Long id,
                               @RequestBody AppGroup appGroup) {
        appGroup.setId(id);
        return groupService.save(appGroup);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        AppGroup currentUser = groupService.findById(id);
        groupService.remove(currentUser);
    }


}
