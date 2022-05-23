package com.example.restblog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="users")
public class User {

//    *********** PROPERTIES *************

    private long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;



//    ONE USER HAS AUTHORED MANY POSTS
//    BRINGS IN THE LIST OF POSTS
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")// we want to ignore the post.user field to prevent a StackOverflowError
    private List<Post> posts = new ArrayList<>();
//^^^^^^^INSTANTIATES AN EMPTY LIST IF USER HAS NO POSTS(INSTEAD OF GETTING "NULL")

    public enum Role {USER, ADMIN}

//    *********** CONSTRUCTOR ************
//    ****** POST CONSTRUCTOR *****
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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
public List<Post> getPosts() {
    return posts;
}

    public void setPosts(List<Post> posts) {
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
