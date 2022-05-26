package com.example.restblog.service;

import com.example.restblog.data.*;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final UserService userService;
    private final PostsRepository postsRepository;
    private final CategoriesRepository categoriesRepository;

    public PostService(UserService userService, PostsRepository postsRepository, CategoriesRepository categoriesRepository) {
        this.userService = userService;
        this.postsRepository = postsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    //    ********** GET ALL POSTS ********
    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }

    //    ******** GET POSTS BY ID ***********
    public Post getPostById(Long id) {
        return postsRepository.findById(id).orElseThrow();
    }

    //*************** USER POST ASSOCIATION *********************
    public void addPost(Post newPost, String username) {
//        USER OBJECT WHO MADE THE POST
        User user = userService.getUserByUsername(username);
//        ASSOCIATING THE POST WITH THE USER OBJECT
        user.getPosts().add(newPost);
//        ASSOCIATING THE USER WITH THE POST OBJECT
        newPost.setUser(user);

        List<Category> categoriesToAdd = new ArrayList<>();

        for (Category category : newPost.getCategories()) {
            categoriesToAdd.add(categoriesRepository.findCategoryByName(category.getName()));
        }

        newPost.setCategories(categoriesToAdd);

        //        SAVE THE NEW POST WITH ASSOCIATED USER TO THE DATABASE
        postsRepository.save(newPost);
    }

    //    ******** UPDATE POSTS *************
    public void updatePosts(Long id, Post post) {
        Post postToUpdate = postsRepository.findById(id).orElseThrow();
        if (post.getContent() != null && !post.getContent().isEmpty()) {
            postToUpdate.setContent(post.getContent());
        }
        if (post.getTitle() != null && !post.getTitle().isEmpty()) {
            postToUpdate.setTitle(post.getTitle());
        }
        postsRepository.save(postToUpdate);
    }

    //    ******** DELETE POST ************
    public void deletePostById(Long id) {
        postsRepository.deleteById(id);
    }
}
