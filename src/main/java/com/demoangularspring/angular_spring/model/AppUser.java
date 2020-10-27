package com.demoangularspring.angular_spring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    private String avatar;
    private String role;

    @ManyToOne
    private AppGroup group;

    private String password;
}
