package com.curd.demo.Crud.dto.user;

import com.curd.demo.Crud.model.UserDetails;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class UserDto {

    private Long id;
    private String email;
    private boolean active;
    @Embedded
    private UserDetails user_details;

    public UserDto(Long id, String email, boolean active, UserDetails user_details) {
        this.id = id;
        this.email = email;
        this.active = active;
        this.user_details = user_details;
    }
}
