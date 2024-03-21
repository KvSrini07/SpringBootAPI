package com.intern.interns.service;

import com.intern.interns.model.UsersModel;
import com.intern.interns.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service

public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String name, String password, String email, String city, String phoneno, String course, String clg) {
        if (name == null || password == null) {
            return null;
        } else {
            if(usersRepository.findFirstByName(name).isPresent()){
                System.out.println("Duplicate Name ! Name is Already Exists !!");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setName(name);
            usersModel.setEmail(email);
            usersModel.setCourse(course);
            usersModel.setClg(clg);
            usersModel.setPhoneno(phoneno);
            usersModel.setPassword(password);
            usersModel.setCity(city);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate(String name, String password){
        return usersRepository.findByNameAndPassword(name, password).orElse(null);
    }
}
