package com.demoangularspring.angular_spring.service.impl;

import com.demoangularspring.angular_spring.model.AppGroup;
import com.demoangularspring.angular_spring.repository.IGroupRepository;
import com.demoangularspring.angular_spring.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    IGroupRepository groupRepository;

    @Override
    public Iterable<AppGroup> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public AppGroup findById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public AppGroup save(AppGroup appGroup) {
        return groupRepository.save(appGroup);
    }

    @Override
    public void remove(AppGroup appGroup) {
        groupRepository.delete(appGroup);
    }
}
