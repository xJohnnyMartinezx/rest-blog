package com.example.restblog.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@Entity
@Table(name="posts")
public class Post {


//    ********* PROPERTIES **********
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JsonIgnoreProperties("posts")// ignore the posts field on the User object to prevent extra data from being returned
    private User user; // each post has only 1 user who authored it

    //    ******* CONSTRUCTOR **********

    public Post() {
    }

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

//    ******** GETTERS AND SETTERS ***********
//   ************ USERS ************
//

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//*****************************


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
