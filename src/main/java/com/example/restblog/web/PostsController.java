package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import com.example.restblog.service.EmailService;
import com.example.restblog.service.PostService;
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
    private final EmailService emailService;
    private final PostService postService;

    public PostsController(UserService userService, EmailService emailService, PostService postService) {
        this.userService = userService;
        this.emailService = emailService;
        this.postService = postService;
    }



    //********* GET ALL METHOD *********
    @GetMapping()
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    //******** GET BY ID *************

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    //******** CREATE POST **********
    @PostMapping("{username}")
    private void createPostByUsername(@PathVariable String username, @RequestBody Post newPost) {
        System.out.println("New post has been created");
        postService.addPost(newPost, username);
        emailService.prepareAndSend(newPost, "New Post Created", "You've created an new post.");

    }

    //    ********* UPDATE POST **********
    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
        System.out.println("Post with ID of " + id + " has been updated");
        postService.updatePosts(id, updatePost);
    }


    //    ********** DELETE POST **********
    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        System.out.println("Post with ID of " + id + " has been deleted");
    }

}

