package com.curd.demo.Crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Embedded
    private UserDetails user_details;

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public UserDetails getUser_details() {
        return user_details;
    }

    public Long getId() {
        return id;
    }

}

