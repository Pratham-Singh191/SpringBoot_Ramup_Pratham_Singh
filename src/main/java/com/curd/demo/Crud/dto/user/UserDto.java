package com.curd.demo.Crud.dto.user;

import com.curd.demo.Crud.model.User;
import com.curd.demo.Crud.model.UserDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
public class UserDto {

    private Long id;
    private String email;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;
    private Set<Long> followers;
    private Set<Long> following;

    @Embedded
    private UserDetails user_details;

    public String getEmail() {
        return email;
    }

    public UserDto(Long id, String email, boolean active, UserDetails user_details, LocalDateTime createdAt, LocalDateTime lastModified ,Set<Long> followers,Set<Long> following) {
        this.id = id;
        this.email = email;
        this.active = active;
        this.user_details = user_details;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
        this.followers=new HashSet<>(followers);
        this.following=new HashSet<>(following);
    }

    public Long getId() {
        return id;
    }
}
