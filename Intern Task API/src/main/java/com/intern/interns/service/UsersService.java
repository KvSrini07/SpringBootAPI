package com.intern.interns.service;

import com.intern.interns.model.UsersModel;
import com.intern.interns.task.entity.Task;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UsersModel> findAllInterns();

    Optional<UsersModel> findById(Integer id);

    UsersModel saveInterns(UsersModel usersModel);

    UsersModel updateInterns(UsersModel usersModel);

    void deleteInterns(Integer id);

    void saveUser(UsersModel usersModel);
    void saveTask(Task task);

    Optional<UsersModel> findByEmail(String email);
}
