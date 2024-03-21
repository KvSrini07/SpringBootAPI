package com.practice.onetomany.onetomany.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDetailsDTO {
    @JsonProperty("userDTO")
    private UserDTO userDTO;
    private UserProfileDTO userProfile;
    private List<TaskDTO> tasks;

    public UserDetailsDTO() {

    }

    @JsonProperty("user")
    public UserDTO getUser() {
        return userDTO;
    }

    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserProfileDTO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDTO userProfile) {
        this.userProfile = userProfile;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public UserDetailsDTO(UserDTO userDTO, UserProfileDTO userProfile, List<TaskDTO> tasks) {
        this.userDTO = userDTO;
        this.userProfile = userProfile;
        this.tasks = tasks;
    }
}
