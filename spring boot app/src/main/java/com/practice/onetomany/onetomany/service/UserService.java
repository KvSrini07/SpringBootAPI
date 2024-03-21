package com.practice.onetomany.onetomany.service;

import com.practice.onetomany.onetomany.dto.TaskDTO;
import com.practice.onetomany.onetomany.dto.UserDTO;
import com.practice.onetomany.onetomany.dto.UserDetailsDTO;
import com.practice.onetomany.onetomany.dto.UserProfileDTO;
import com.practice.onetomany.onetomany.entity.Task;
import com.practice.onetomany.onetomany.entity.User;
import com.practice.onetomany.onetomany.entity.UserProfile;
import com.practice.onetomany.onetomany.repository.TaskRepository;
import com.practice.onetomany.onetomany.repository.UserProfileRepository;
import com.practice.onetomany.onetomany.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;


    private final UserProfileRepository userProfileRepository;


    private final TaskRepository taskRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.taskRepository = taskRepository;
    }


    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public List <Task> getTasksByUsername(String username){
        return taskRepository.findByUserUsername(username);
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUsers(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserDetailsDTO getUserDetailsByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserProfile userProfile = userProfileRepository.findByUser(user);
        List<Task> tasks = taskRepository.findByUser(user);

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUser(new UserDTO(user.getUsername(), user.getEmail()));
        userDetailsDTO.setUserProfile(new UserProfileDTO(userProfile.getFullName(), userProfile.getAddress()));

        List<TaskDTO> taskDTOs = tasks.stream()
                .map(task -> new TaskDTO(task.getTaskDescription()))
                .collect(Collectors.toList());
        userDetailsDTO.setTasks(taskDTOs);

        return userDetailsDTO;
    }
    @Transactional
    public User saveUserWithDetails(UserDetailsDTO userDetailsDTO) {
        // Create User
        User user = new User();
        user.setUsername(userDetailsDTO.getUser().getUsername());
        user.setEmail(userDetailsDTO.getUser().getEmail());
        userRepository.save(user);

        // Create UserProfile
        UserProfile userProfile = new UserProfile();
        userProfile.setFullName(userDetailsDTO.getUserProfile().getFullName());
        userProfile.setAddress(userDetailsDTO.getUserProfile().getAddress());
        userProfile.setUser(user);
        userProfileRepository.save(userProfile);

        // Create Tasks
        List<TaskDTO> taskDTOs = userDetailsDTO.getTasks();
        if (taskDTOs != null) {
            for (TaskDTO taskDTO : taskDTOs) {
                Task task = new Task();
                task.setTaskDescription(taskDTO.getTaskDescription());
                task.setUser(user);
                taskRepository.save(task);
            }
        }

        return user;
    }
    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        UserProfile userProfile = new UserProfile();
        userProfile.setFullName(userProfile.getFullName());
        userProfile.setAddress(userProfile.getAddress());
        userProfile.setUser(user);

        List<Task> tasks = new ArrayList<>();
        for (TaskDTO taskDTO : userDTO.getTasks()) {
            Task task = new Task();
            task.setTaskDescription(taskDTO.getTaskDescription());
            task.setUser(user);
            tasks.add(task);
        }

        user.setUserProfile(userProfile);
        user.setTasks(tasks);

        userRepository.save(user);
    }

}
