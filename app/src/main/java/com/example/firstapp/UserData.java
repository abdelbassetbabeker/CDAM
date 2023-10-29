package com.example.firstapp;


import java.io.Serializable;

public class UserData implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String coCode;
    private String mobile;

    public UserData(String firstName, String lastName, String email, String password, String coCode, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.coCode = coCode;
        this.mobile = mobile;
    }

    // Define getters for the fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCoCode() {
        return coCode;
    }

    public String getMobile() {
        return mobile;
    }
}