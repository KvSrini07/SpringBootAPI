package com.practice.onetomany.onetomany.entity;

import jakarta.persistence.*;
    @Entity
    @Table(name = "user_profile")
    public class UserProfile {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String fullName;
        private String address;

        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;


        public UserProfile(Long id, String fullName, String address, User user) {
            this.id = id;
            this.fullName = fullName;
            this.address = address;
            this.user = user;
        }

        public UserProfile() {

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }