package com.curd.demo.Crud.controller.auth;

import com.curd.demo.Crud.controller.ResponseBody;
import com.curd.demo.Crud.dto.auth.LoginDto;
import com.curd.demo.Crud.model.User;
import com.curd.demo.Crud.repository.UserRepository;
import com.curd.demo.Crud.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<ResponseBody<String>> login(@RequestBody LoginDto loginDto) throws Exception{
        User user =  userRepository.existsByEmail(loginDto.getUsername());
        if(user == null || !loginDto.getPassword().equals(user.getPassword())) throw new Exception("Login failed user not found");
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseBody<String>(HttpStatus.OK,"Successfully login", jwtService.generateToken(user.getUsername())));
    }
}
