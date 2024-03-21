package com.practice.onetomany.onetomany.service;

import com.practice.onetomany.onetomany.dto.TaskDTO;
import com.practice.onetomany.onetomany.entity.Task;
import com.practice.onetomany.onetomany.repository.TaskRepository;
import com.practice.onetomany.onetomany.repository.UserProfileRepository;
import com.practice.onetomany.onetomany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private TaskRepository taskRepository;


    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }


    public void deleteTask(Long userId) {
        taskRepository.deleteById(userId);
    }

    public void createTask(TaskDTO taskDTO) {
        Task task = convertToEntity(taskDTO);
        taskRepository.save(task);
    }

    private Task convertToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskDescription(taskDTO.getTaskDescription());
        // Set other properties as needed
        return task;
    }
}
