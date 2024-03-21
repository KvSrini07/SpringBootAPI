package com.practice.onetomany.onetomany.dto;

public class TaskDTO {
    private String taskDescription;
    private UserDTO userDTO;
    public TaskDTO() {
        // Default constructor
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskDTO(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
