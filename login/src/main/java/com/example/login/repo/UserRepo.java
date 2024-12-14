package com.example.login.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.entity.User;



public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}


