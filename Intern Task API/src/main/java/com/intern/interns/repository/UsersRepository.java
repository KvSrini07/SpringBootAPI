package com.intern.interns.repository;


import com.intern.interns.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    Optional<UsersModel> findByNameAndPassword(String name, String password);

    Optional<UsersModel> findFirstByName(String name);
}
