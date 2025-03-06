package com.curd.demo.Crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Email(message = "Must be a valid email")
    @Column(name = "email")
    private String email;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^[A-Za-z0-9_]+$")
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Embedded
    private UserDetails user_details;

    @PrePersist
    private void prePersist(){
        this.createdAt= LocalDateTime.now();
        this.lastModified= LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.lastModified= LocalDateTime.now();
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }
}

