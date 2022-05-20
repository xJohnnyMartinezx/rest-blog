package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import com.example.restblog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.restblog.web.UsersController;
@Service
@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final UserService userService;

    public PostsController(UserService userService) {
        this.userService = userService;
    }


    //********* GET ALL METHOD *********
    @GetMapping()
    public List<Post> getAll() {
        return userService.getPosts();
    }

    //******** GET BY ID *************

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : userService.getPosts()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return null;
    }

    //******** CREATE POST **********
    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println("New post has been created");

    }

    //    ********* UPDATE POST **********
    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
        System.out.println("The id is: " + id);
        System.out.println("Post has been updated");
    }


    //    ********** DELETE POST **********
    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        System.out.println("Post with ID of " + id + " has been deleted");
    }

}

