package com.curd.demo.Crud.dto.user;

import com.curd.demo.Crud.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDtoMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.isActive(), user.getUser_details(),  user.getCreatedAt(), user.getLastModified(), user.getFollowers().stream().map(User::getId).collect(Collectors.toSet()), new HashSet<>());
    }
}
