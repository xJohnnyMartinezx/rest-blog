package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    ArrayList<Post> posts = new ArrayList<>();
    Post post1 = new Post(1L, "My First Post", "This is the body/contents of my first post.");
    Post post2 = new Post(2L, "My Second Post", "This is the body/contents of my second post.");
    Post post3 = new Post(3L, "My Third Post", "This is the body/contents of my third post.");


    public ArrayList<Post> setPost() {
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }

    //********* GET ALL METHOD *********
    @GetMapping()
    public ArrayList<Post> getAll() {
        posts.removeAll(posts);
        return setPost();
    }

    //******** GET BY ID *************
    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : getAll()) {
            if (id == post.getId()) {
                return post;
            }
        }
        return new Post();
    }

    //******** CREATE POST **********
    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost);

    }

    //    ********* UPDATE POST **********
    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
        System.out.println(id);
        System.out.println(updatePost);
    }


//    ********** DELETE POST **********
    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        System.out.println(id);
    }

}

