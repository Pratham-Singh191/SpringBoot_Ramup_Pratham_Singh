package com.curd.demo.Crud.dto.auth;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
