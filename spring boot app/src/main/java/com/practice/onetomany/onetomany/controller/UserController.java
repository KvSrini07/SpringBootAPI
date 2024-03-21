package com.practice.onetomany.onetomany.controller;


import com.practice.onetomany.onetomany.dto.UserDTO;
import com.practice.onetomany.onetomany.dto.UserDetailsDTO;
import com.practice.onetomany.onetomany.dto.UserProfileDTO;
import com.practice.onetomany.onetomany.entity.Task;
import com.practice.onetomany.onetomany.entity.User;
import com.practice.onetomany.onetomany.service.TaskService;
import com.practice.onetomany.onetomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/{username}")
//    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable String username) {
//        UserDetailsDTO userDetailsDTO = userService.getUserDetailsByUsername(username);
//
//        if (userDetailsDTO != null) {
//            return ResponseEntity.ok(userDetailsDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    @PostMapping("/save")
    public ResponseEntity<User> createUserWithDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
        User createdUser = userService.saveUserWithDetails(userDetailsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    // GET: Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // GET: Get a user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // POST: Create a new user
    @PostMapping("/saveuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // PUT: Update an existing user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setId(userId);
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // DELETE: Delete a user by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long userId) {
        userService.deleteUsers(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        List<Task> tasks = userService.getTasksByUsername(username);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        try {
            userService.createUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

}

