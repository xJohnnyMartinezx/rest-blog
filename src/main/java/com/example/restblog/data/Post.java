package com.example.restblog.data;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class Post {


//    ********* PROPERTIES **********
    private Long id;
    private String title;
    private String content;

//    ******* CONSTRUCTOR **********


    public Post() {
    }

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

//    ******** GETTERS AND SETTERS ***********


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


}