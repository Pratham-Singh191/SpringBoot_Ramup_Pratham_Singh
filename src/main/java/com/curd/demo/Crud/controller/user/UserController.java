package com.curd.demo.Crud.controller.user;


import com.curd.demo.Crud.dto.user.UserDto;
import com.curd.demo.Crud.model.User;
import com.curd.demo.Crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user-details/{id}")
    public ResponseEntity<UserDto> getUserDetailsById(@PathVariable Long id){
        UserDto user = userService.getUserDetailsById(id);
        if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers(){
        return new ArrayList<User>(userService.getAllUsers());
    }

    @GetMapping("/active-users")
    public List<UserDto> getAllActiveUsers(){
        return userService.getAllActiveUsers();
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user){
        User result = userService.addUser(user);
        return result;
    }

    @PostMapping("/update-user")
    public UserDto updateUserDetails(@RequestBody User user){
        return userService.updateUserDetails(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUserbyID(@PathVariable Long id){
        return userService.deleteUserByUserId(id);
    }

}
