package com.curd.demo.Crud.controller;


import com.curd.demo.Crud.controller.user.ResponseBody;
import com.curd.demo.Crud.dto.user.UserDto;
import com.curd.demo.Crud.model.User;
import com.curd.demo.Crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user-details/{id}")
    public ResponseEntity<UserDto> getUserDetailsById(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserDetailsById(id));
    }

    @GetMapping("all-users")
    public ResponseEntity<ResponseBody<List<UserDto>>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBody<List<UserDto>>(HttpStatus.FOUND, "List of all users", userService.getAllUsers()));
    }

    @GetMapping("active-users")
    public ResponseEntity<ResponseBody<List<UserDto>>> getAllActiveUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBody<List<UserDto>>(HttpStatus.FOUND, "List of active users", userService.getAllActiveUsers()));
    }

    @PostMapping("add-user")
    public ResponseEntity<UserDto> addNewUser(@RequestBody User user) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.addUser(user));
    }

    @PatchMapping("update-user")
    public UserDto updateUserDetails(@RequestBody User user){
        return userService.updateUserDetails(user);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<ResponseBody<String>> deleteUserbyID(@PathVariable Long id) throws Exception{
        userService.deleteUserByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseBody<String>(HttpStatus.OK,"Deleted Successfully!", null ));
    }

}
