package com.practice.onetomany.onetomany.dto;

public class UserProfileDTO {
    private String fullName;
    private String address;

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

    public UserProfileDTO(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }
}
