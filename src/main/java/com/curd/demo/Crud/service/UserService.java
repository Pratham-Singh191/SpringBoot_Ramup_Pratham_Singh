package com.curd.demo.Crud.service;

import com.curd.demo.Crud.dto.user.UserDto;
import com.curd.demo.Crud.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<UserDto> getAllUsers();
    public List<UserDto> getAllActiveUsers();
    public UserDto getUserDetailsById(Long id) throws Exception;
    public boolean doesExistsByEmail(String email) ;
    public boolean doesExistsWithId(Long id);
    public UserDto addUser(User user) throws Exception;
    public void deleteUserByUserId(Long id) throws Exception;
    public UserDto updateUserDetails(User user);
    public void follow(String username);
}
