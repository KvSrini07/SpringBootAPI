package com.intern.interns.service.implem;

import com.intern.interns.model.UsersModel;
import com.intern.interns.repository.UsersRepository;
import com.intern.interns.service.UsersService;
import com.intern.interns.task.entity.Task;
import com.intern.interns.taskrespository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceImpl implements UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private TaskRepository taskRepository;

    public ServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public List<UsersModel> findAllInterns() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<UsersModel> findById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public UsersModel saveInterns(UsersModel usersModel) {
        return usersRepository.save(usersModel);
    }

    @Override
    public UsersModel updateInterns(UsersModel usersModel) {
        return usersRepository.save(usersModel);
    }
    @Override
    public void deleteInterns(Integer id) {
        usersRepository.deleteById(id);

    }
    @Override
    public void saveUser(UsersModel usersModel) {
        usersRepository.save(usersModel);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<UsersModel> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
