package com.example.restblog.service;

import com.example.restblog.data.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    //    INJECTS USER_REPOSITORY AND POSTS_REPOSITORY INTO USER SERVICE CLASS VIA CONSTRUCTOR INJECTION
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final CategoriesRepository categoriesRepository;

    public UserService(UsersRepository usersRepository, PostsRepository postsRepository, CategoriesRepository categoriesRepository) {
        this.usersRepository = usersRepository;
        this.postsRepository = postsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    //*************** USER POST ASSOCIATION *********************
    public void addPost(Post newPost, String username) {
//        USER OBJECT WHO MADE THE POST
        User user = getUserByUsername(username);
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

    //************************** USER METHODS ****************************
    //    ********** GET ALL USERS ********
    public List<User> getUsersList() {
        return usersRepository.findAll();
    }

    //    ******** GET USERS BY ID ***********
    public User getUserById(Long id) {
        return usersRepository.findById(id).orElseThrow();
    }

    //    ******** GET USER BY USERNAME ***********
    public User getUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    //    ******** GET USER BY EMAIL ***********
    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    //    ********** UPDATE USER PASSWORD ***********
    public void updateUserPassword(Long id, String oldPassword, String newPassword) {
        User userToUpdate = getUserById(id);
        userToUpdate.setPassword(newPassword);
        usersRepository.save(userToUpdate);
        System.out.println("New password is: " + userToUpdate.getPassword());
    }

//    *********** CREATE NEW USER *************
//    public User addNewUser(String username, String email, String password){
//        return usersRepository.createNewUser(username, email, password);
    public void addNewUser(User newUser){
        usersRepository.save(newUser);
    }


    //    ********************** POST METHODS ************************
//    ********** GET ALL POSTS ********
    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }

    //    ******** GET POSTS BY ID ***********
    public Post getPostById(Long id) {
        return postsRepository.findById(id).orElseThrow();
    }

    //    ******** CREATE POST ***********
//    public void addPost(Post newPost, String username) {
//        User user = usersRepository.findByUsername(username);
//        user.getPosts().add(newPost);
//        newPost.setUser(user);
//        postsRepository.save(newPost);
//    }

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




