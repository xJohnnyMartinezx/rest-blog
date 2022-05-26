package com.example.restblog.dto;

public class CreateUserDto {

//    ****** PROPERTIES ******
    private String username;
    private String email;
    private String password;

//    ******** CONSTRUCTOR *******

    public CreateUserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


//    ******* GETTERS AD SETTERS ******

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    ******* TO STRING *******

    @Override
    public String toString() {
        return "CreateUserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
