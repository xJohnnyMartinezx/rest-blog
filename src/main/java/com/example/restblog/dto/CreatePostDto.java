package com.example.restblog.dto;

import java.util.List;

public class CreatePostDto {

    //    ******** PROPERTIES *********
    private String title;
    private String content;

    private List<String> categories;

//    ***** CONSTRUCTOR **********

    public CreatePostDto(String title, String content, List<String> categories) {
        this.title = title;
        this.content = content;
        this.categories = categories;
    }

//    ******* GETTERS AND SETTERS ********

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getCategories() {
        return categories;
    }


}
