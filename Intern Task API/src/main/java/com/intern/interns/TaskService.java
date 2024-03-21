package com.intern.interns;

import com.intern.interns.model.UsersModel;
import com.intern.interns.repository.UsersRepository;
import com.intern.interns.task.entity.Task;
import com.intern.interns.taskrespository.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
//
//public static Task authenticate(String name){
//    return taskRepository.findByName(name).orElse(null);
//}
}
