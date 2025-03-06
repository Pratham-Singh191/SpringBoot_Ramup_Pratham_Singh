package com.curd.demo.Crud.service;

import com.curd.demo.Crud.dto.user.UserDto;
import com.curd.demo.Crud.dto.user.UserDtoMapper;
import com.curd.demo.Crud.repository.UserRepository;
import com.curd.demo.Crud.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDtoMapper userDtoMapper;


    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(user -> userDtoMapper.apply(user)).toList();
    }

    public List<UserDto> getAllActiveUsers(){
        return userRepository.getAllActiveUsers().stream().map(user -> userDtoMapper.apply(user)).toList();
    }

    public UserDto getUserDetailsById(Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw  new Exception(MessageFormat.format("User with id {0} doesn't exists", id));
        return userDtoMapper.apply(user.get());
    }

    public boolean doesExistsByEmail(String email){
        User user = userRepository.existsByEmail(email);
        return user!=null;
    }

    public boolean doesExistsWithId(Long id){
        return userRepository.existsById(id);
    }

    public UserDto addUser(User user) throws Exception {
        boolean doesExists= userRepository.existsByEmail(user.getEmail()) != null;
        if(doesExists) throw new Exception(MessageFormat.format("User with email {0} already exists", user.getEmail()));
        log.info(MessageFormat.format("User with id {0} added successfully!", user.getId()));

        return userDtoMapper.apply(userRepository.save(user));
    }

    public void deleteUserByUserId(Long id) throws Exception{
        if(userRepository.existsById(id)) throw new Exception(MessageFormat.format("User with id {0} doesn't exists", id));
        log.info(MessageFormat.format("User with id {0} deleted successfully!", id));
        userRepository.deleteById(id);
    }

    public UserDto updateUserDetails(User user){
        return userDtoMapper.apply(userRepository.save(user));
    }

}
