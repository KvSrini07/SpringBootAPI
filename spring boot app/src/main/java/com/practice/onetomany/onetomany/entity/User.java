package com.practice.onetomany.onetomany.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_tab")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();


    public User(UserProfile userProfile, List<Task> tasks) {

        this.userProfile = userProfile;
        this.tasks = tasks;
    }

    public User(List<Task> tasks) {

        this.tasks = tasks;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public User(Long id, String username, String email, UserProfile userProfile, List<Task> tasks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userProfile = userProfile;
        this.tasks = tasks;
    }

    public void setTasks(List<Task> tasks) {
    }
}
