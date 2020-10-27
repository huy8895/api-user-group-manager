package com.demoangularspring.angular_spring.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table()
public class AppGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
