package com.curd.demo.Crud.controller.user;


import com.curd.demo.Crud.controller.ResponseBody;
import com.curd.demo.Crud.dto.user.UserDto;
import com.curd.demo.Crud.model.User;
import com.curd.demo.Crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("user-details/{id}")
    public ResponseEntity<UserDto> getUserDetailsById(@PathVariable Long id) throws Exception{
        System.out.println(userService.getUserDetailsById(id));
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserDetailsById(id));
    }

    @GetMapping("all-users")
    public ResponseEntity<com.curd.demo.Crud.controller.ResponseBody<List<UserDto>>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new com.curd.demo.Crud.controller.ResponseBody<List<UserDto>>(HttpStatus.FOUND, "List of all users", userService.getAllUsers()));
    }

    @GetMapping("active-users")
    public ResponseEntity<com.curd.demo.Crud.controller.ResponseBody<List<UserDto>>> getAllActiveUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new com.curd.demo.Crud.controller.ResponseBody<List<UserDto>>(HttpStatus.FOUND, "List of active users", userService.getAllActiveUsers()));
    }

    @PostMapping("add-user")
    public ResponseEntity<UserDto> addNewUser(@RequestBody User user) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.addUser(user));
    }

    @GetMapping("follow/{id}")
    public void follow(@PathVariable Long id) throws Exception{
        userService.follow(userService.getUserDetailsById(id).getEmail());
    }

    @PatchMapping("update-user")
    public UserDto updateUserDetails(@RequestBody User user){
        return userService.updateUserDetails(user);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<com.curd.demo.Crud.controller.ResponseBody<String>> deleteUserbyID(@PathVariable Long id) throws Exception{
        userService.deleteUserByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseBody<String>(HttpStatus.OK,"Deleted Successfully!", null ));
    }

}
