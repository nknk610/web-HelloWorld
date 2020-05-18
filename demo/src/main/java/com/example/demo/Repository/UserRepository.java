package com.example.demo.Repository;

import java.util.Optional;

import com.example.demo.Domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}