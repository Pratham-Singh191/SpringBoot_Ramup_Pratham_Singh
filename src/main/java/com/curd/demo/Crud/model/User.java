package com.curd.demo.Crud.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Email(message = "Must be a valid email")
    @Column(name = "email")
    private String email;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^[A-Za-z0-9_]+$")
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Embedded
    private UserDetails user_details;

    @ManyToMany
    @JoinTable(
            name = "connections",
            joinColumns = @JoinColumn(name = "follower"),
            inverseJoinColumns = @JoinColumn(name = "followee")
    )
    private Set<User> followers = new HashSet<>();

    @ManyToMany(mappedBy = "followers")
    private Set<User> following = new HashSet<>();


    @PrePersist
    private void prePersist(){
        this.createdAt= LocalDateTime.now();
        this.lastModified= LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.lastModified= LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public UserDetails getUser_details() {
        return user_details;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return org.springframework.security.core.userdetails.UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return org.springframework.security.core.userdetails.UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return org.springframework.security.core.userdetails.UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return org.springframework.security.core.userdetails.UserDetails.super.isEnabled();
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<User> getFollowing() {
        return following;
    }
}

