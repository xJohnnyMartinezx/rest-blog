package com.example.restblog.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class User {

//    *********** PROPERTIES *************

    private long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Role role = Role.USER;



//    ONE USER HAS AUTHORED MANY POSTS
//    BRINGS IN THE LIST OF POSTS
    private Collection<Post> posts = new ArrayList<>();
//^^^^^^^INSTANTIATES AN EMPTY LIST IF USER HAS NO POSTS(INSTEAD OF GETTING "NULL")



    public enum Role {USER, ADMIN}

//    *********** CONSTRUCTOR ************
//    ****** POST CONSTRUCTOR *****
public User(Collection<Post> posts) {
    this.posts = posts;
}
//*************************************

    public User() {

    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;

    }

//    *********** GETTERS AND SETTERS **********
//    **********POST GETTERS AND SETTERS *******
public Collection<Post> getPosts() {
    return posts;
}

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }
//****************************************


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



//    **********TO STRING **********


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", role=" + role +
                '}';
    }
}
