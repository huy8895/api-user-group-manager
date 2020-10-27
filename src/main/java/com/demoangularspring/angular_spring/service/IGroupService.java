package com.demoangularspring.angular_spring.service;

import com.demoangularspring.angular_spring.model.AppGroup;

public interface IGroupService {
    Iterable<AppGroup> findAll();

    AppGroup findById(Long id);

    AppGroup save(AppGroup appGroup);

    void remove(AppGroup appGroup);


}
