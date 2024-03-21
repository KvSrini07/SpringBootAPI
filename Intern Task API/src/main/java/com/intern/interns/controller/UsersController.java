package com.intern.interns.controller;

import com.intern.interns.model.UsersModel;
import com.intern.interns.service.UsersService;
import com.intern.interns.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intern")
public class UsersController {

    @Autowired
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<UsersModel> findAllInterns() {
        return usersService.findAllInterns();
    }

    @GetMapping("/{id}")
    public Optional<UsersModel> findById(@PathVariable("id") Integer id) {
        return usersService.findById(id);
    }

    @GetMapping("/get/{email}")
    public Optional<UsersModel> findByEmail(@PathVariable("email") String email) {
        return usersService.findByEmail(email);
    }
    @PutMapping
    public UsersModel updateInterns(@RequestBody UsersModel usersModel) {
        return usersService.updateInterns(usersModel);
    }

    @DeleteMapping("/{id}")
    public void deleteInterns(@PathVariable("id") Integer id) {
        usersService.deleteInterns(id);
    }

    @PostMapping("/submit")
    public ResponseEntity<UsersModel> registerUser(@RequestBody UsersModel usersModel, Task task){
        // Save user
        usersService.saveUser(usersModel);

        // Save task
        usersService.saveTask(usersModel.getTask());


        return ResponseEntity.status(HttpStatus.CREATED).body(usersModel);
    }
}
//@Controller
//
//public class UsersController {
//
//    private final UsersService usersService;
//
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//
//    @GetMapping("/register")
//    public String getRegisterPage(Model model){
//        model.addAttribute("registerRequest",new UsersModel());
//        return "register_page";
//    }
//
//    @GetMapping("/login")
//    public String getLoginPage(Model model){
//        model.addAttribute("loginRequest", new UsersModel());
//        return "login_page";
//    }
//    @PostMapping("/register")
//    public String register(@ModelAttribute UsersModel usersModel){
//        System.out.println("register request: " + usersModel);
//        UsersModel registeredUser = usersService.registerUser(usersModel.getName(),usersModel.getPassword(),usersModel.getEmail(),usersModel.getCity(),usersModel.getPhoneno(),usersModel.getCourse(),usersModel.getClg());
//        return registeredUser == null ? "error_page" : "redirect:/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute UsersModel usersModel, Model model){
//        System.out.println("login request: " + usersModel);
//        UsersModel authenticated = usersService.authenticate(usersModel.getName(),usersModel.getPassword());
//        if(authenticated !=null){
//            model.addAttribute("userLogin", authenticated.getName());
//            return "personal_page";
//        }
//        else {
//            return "error_page";
//        }
//    }

