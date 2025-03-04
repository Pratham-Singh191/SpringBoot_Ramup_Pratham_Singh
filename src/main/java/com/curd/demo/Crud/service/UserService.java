package com.curd.demo.Crud.service;

import com.curd.demo.Crud.dto.user.UserDto;
import com.curd.demo.Crud.dto.user.UserDtoMapper;
import com.curd.demo.Crud.repository.UserRepository;
import com.curd.demo.Crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDtoMapper userDtoMapper;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<UserDto> getAllActiveUsers(){
        return userRepository.getAllActiveUsers().stream().map(user -> userDtoMapper.apply(user)).toList();
    }

    public UserDto getUserDetailsById(Long id){
        Optional<User> user =userRepository.findById(id);
        return user.map(value -> userDtoMapper.apply(value)).orElse(null);

    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUserByUserId(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserDto updateUserDetails(User user){
        return userDtoMapper.apply(userRepository.save(user));
    }

}
