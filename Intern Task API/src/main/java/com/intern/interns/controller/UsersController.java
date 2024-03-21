package com.intern.interns.controller;

import com.intern.interns.model.UsersModel;
import com.intern.interns.repository.UsersRepository;
import com.intern.interns.service.UsersService;
import com.intern.interns.task.entity.Task;
import com.intern.interns.taskrespository.TaskRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TaskRepository taskRepository;
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
//
//    @GetMapping("/user-form")
//    public String showUserForm(Model model){
//        model.addAttribute("user",new UsersModel());
//        return "user-form";
//    }
//
//    @PostMapping("/create-user")
//    public String createUser(@ModelAttribute UsersModel usersModel, Model model){
//        UsersModel savedUser= usersRepository.save(usersModel);
//
//        Task task = new Task();
//        task.setName(savedUser.getName());
//        task.setTaskdes("Default Task");
//
//        taskRepository.save(task);
//
//        model.addAttribute("message", "User and Task Created Successfully");
//
//        return "redirect:/user-form";
//    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel) {
        System.out.println("register request: " + usersModel);
        UsersModel registeredUser = usersService.registerUser(usersModel.getName(), usersModel.getPassword(), usersModel.getEmail(), usersModel.getCity(), usersModel.getPhoneno(), usersModel.getCourse(), usersModel.getClg());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("loginRequest: " + usersModel);
        UsersModel authenticated = usersService.authenticate(usersModel.getName(), usersModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getName());
            return "personal_page";
        } else {
            return "error_page";
        }
    }
}

