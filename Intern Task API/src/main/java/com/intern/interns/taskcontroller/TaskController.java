package com.intern.interns.taskcontroller;
import com.intern.interns.task.entity.Task;
import com.intern.interns.tasksService.TasksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
    public class TaskController {

    @Autowired
    private final TasksServices taskService;


    public TaskController(TasksServices taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> findAllTask() {
        return taskService.findAllTask();
    }

    @GetMapping("/{id}")
    public Optional<Task> findById(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
//    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
//        Task savedTask = taskService.saveTask(task);
//        return ResponseEntity.status(HttpStatus.CREATED).body("INSERTED");
//    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }


}
