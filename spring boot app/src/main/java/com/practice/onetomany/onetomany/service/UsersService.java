package com.practice.onetomany.onetomany.service;

import com.practice.onetomany.onetomany.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    User saveUser(User user);

    User updateUsers(User user);

    void deleteUser(Long id);
}
