package com.intern.interns.tasksService;

import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface TasksServices {

        List<com.intern.interns.task.entity.Task> findAllTask();

        Optional<com.intern.interns.task.entity.Task> findById(Long id);

        com.intern.interns.task.entity.Task saveTask(com.intern.interns.task.entity.Task task);

        com.intern.interns.task.entity.Task updateTask(com.intern.interns.task.entity.Task task);

        void deleteTask(Long id);
}
