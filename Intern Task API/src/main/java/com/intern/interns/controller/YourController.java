//package com.intern.interns.controller;
//
//import com.intern.interns.task.entity.Task;
//import com.intern.interns.taskrespository.TaskRepository;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.intern.interns.repository.UsersRepository;
//
//@RestController
//public class YourController {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    private TaskRepository taskRepository;
//
//
//    @GetMapping("/some-endpoint")
//    public ResponseEntity<?> someEndpoint(Authentication authentication) {
//        // Get the user's email from authentication principal
//        String userName = authentication.name();
//
//        Task task = new Task();
//        task.setName(userName);
//
//        taskRepository.save(task);
////        // Create a new task object and set the email
////        Task task = new Task();
////        task.setEmail(userEmail);
////
////        taskRepository.save(task);
//
//        return ResponseEntity.ok("Task created successfully");
//    }
//}
//
//
//
