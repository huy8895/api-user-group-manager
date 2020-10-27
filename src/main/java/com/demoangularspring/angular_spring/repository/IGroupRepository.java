package com.demoangularspring.angular_spring.repository;

import com.demoangularspring.angular_spring.model.AppGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<AppGroup,Long> {
}
