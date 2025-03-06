package com.curd.demo.Crud.repository;

import com.curd.demo.Crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query( value = "select * from users where active is true", nativeQuery = true)
    List<User> getAllActiveUsers();

    @Query(value = "select * from users where email = :email", nativeQuery = true)
    User existsByEmail(@Param("email") String email);
}
