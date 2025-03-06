package com.curd.demo.Crud.dto.user;

import com.curd.demo.Crud.model.UserDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserDto {

    private Long id;
    private String email;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;

    @Embedded
    private UserDetails user_details;

    public UserDto(Long id, String email, boolean active, UserDetails user_details, LocalDateTime createdAt, LocalDateTime lastModified ) {
        this.id = id;
        this.email = email;
        this.active = active;
        this.user_details = user_details;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public Long getId() {
        return id;
    }
}
