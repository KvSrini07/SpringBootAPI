package com.practice.onetomany.onetomany.repository;

import com.practice.onetomany.onetomany.entity.Task;
import com.practice.onetomany.onetomany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);

    List<Task> findByUserUsername(String username);
}

