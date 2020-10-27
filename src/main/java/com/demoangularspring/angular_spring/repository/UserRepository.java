package com.demoangularspring.angular_spring.repository;


import com.demoangularspring.angular_spring.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {
}
