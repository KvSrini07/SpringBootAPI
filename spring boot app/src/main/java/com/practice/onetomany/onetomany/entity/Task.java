package com.practice.onetomany.onetomany.entity;

import jakarta.persistence.*;
    @Entity
    @Table(name = "users_task")
    public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String taskDescription;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        public Task(Long id, String taskDescription, User user) {
            this.id = id;
            this.taskDescription = taskDescription;
            this.user = user;
        }

        public Task() {

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        // Other fields, getters, setters
    }
