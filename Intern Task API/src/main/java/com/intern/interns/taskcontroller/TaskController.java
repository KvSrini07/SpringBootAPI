package com.intern.interns.taskcontroller;

import com.intern.interns.TaskService;
import com.intern.interns.model.UsersModel;
import com.intern.interns.task.entity.Task;
import com.intern.interns.taskrespository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Date;

@Controller
@RequestMapping("/tasks")
    public class TaskController {

        @Autowired
        private TaskRepository taskRepository;

        @GetMapping("/personal_page")
        public String personalPage() {
            return "personal_page";
        }

        @GetMapping("/task")
        public String task(Model model) {
            model.addAttribute("task", new Task());
            return "task";
        }
        @PostMapping("/saveTask")
        public String saveTask(Task task, Model model) {
            taskRepository.save(task);
            model.addAttribute("successMessage", "Task updated successfully");
            return "redirect:/tasks/success";
        }
        @GetMapping("/success")
        public String success(Model model){
            return "success";
        }

//    @PostMapping("/tasklogin")
//    public String findByName(@ModelAttribute Task task, Model model) {
//        System.out.println("taskRequest: " + task);
//        Task authenticated = TaskService.authenticate(Task.getName());
//        if (authenticated != null) {
//            model.addAttribute("taskLogin", Task.getName());
//            return "personal_page";
//        } else {
//            return "error_page";
//        }
//    }
//
//
//        @GetMapping("/task-form")
//        public String showTaskForm(Model model) {
//            model.addAttribute("task", new Task());
//            return "task-form";
//        }

//        @PostMapping("/saveTask")
//        public String saveTask(@ModelAttribute Task task, @RequestParam String name, Model model) {
//            // Assuming you have a service layer to handle task creation
//            // You should set the user's name and save the task
//            task.setName(name);
//            taskRepository.save(task);
//
//            // You can add more attributes to the model if needed
//            model.addAttribute("message", "Task saved successfully");
//
//            return "redirect:/tasks/task-form";
//        }
    }



