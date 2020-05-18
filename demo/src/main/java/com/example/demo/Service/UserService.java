package com.example.demo.Service;

import java.util.List;

import com.example.demo.Domain.User;

public interface UserService {
    User add(User user);
    User login(String email, String password);
    User update(Long id, User user);
    boolean delete(Long id);
    User view(Long id);
    List<User> list();
}