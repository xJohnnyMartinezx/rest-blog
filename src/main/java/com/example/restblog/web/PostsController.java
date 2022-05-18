package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    List<Post> posts = new ArrayList<>();


    //********* GET ALL METHOD *********
    @GetMapping()
    public List<Post> getAll() {
        posts.add(new Post(1L, "My First Post", "This is the body/contents of my first post."));
        posts.add(new Post(2L, "My Second Post", "This is the body/contents of my second post."));
        posts.add(new Post(3L, "My Third Post", "This is the body/contents of my third post."));
        return posts;
    }

    //******** GET BY ID *************

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : getAll()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return new Post();
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

