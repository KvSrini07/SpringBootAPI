package com.intern.interns.repository;

import org.springframework.stereotype.Repository;
import com.intern.interns.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    Optional <UsersModel> findByEmail(String email);
}
