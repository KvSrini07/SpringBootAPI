package com.intern.interns.tasksService.taskimpl;

import com.intern.interns.task.entity.Task;
import com.intern.interns.taskrespository.TaskRepository;
import com.intern.interns.tasksService.TasksServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class TaskServiceImpl implements TasksServices {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }
    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
