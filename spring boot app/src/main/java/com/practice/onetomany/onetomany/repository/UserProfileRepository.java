package com.practice.onetomany.onetomany.repository;

import com.practice.onetomany.onetomany.entity.User;
import com.practice.onetomany.onetomany.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByUser(User user);
}
