package com.example.restblog.web.dto;

public class UpdateUserDto{

//    ********* PROPERTIES *********
    private long id;
    private String username;
    private String email;

//    ******* CONSTRUCTOR ************

    public UpdateUserDto(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

//    ******* GETTERS AND SETTERS ********

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

//    ******* TO STRING *******

    @Override
    public String toString() {
        return "UpdateUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}