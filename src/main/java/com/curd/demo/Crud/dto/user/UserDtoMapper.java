package com.curd.demo.Crud.dto.user;

import com.curd.demo.Crud.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDtoMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        UserDto uDto= new UserDto(user.getId(), user.getEmail(), user.isActive(), user.getUser_details(), user.getCreatedAt(), user.getLastModified());
        return new UserDto(user.getId(), user.getEmail(), user.isActive(), user.getUser_details(),  user.getCreatedAt(), user.getLastModified());
    }
}
