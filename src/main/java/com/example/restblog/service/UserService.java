package com.example.restblog.service;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.User;
import com.example.restblog.data.UsersRepository;
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

    public UserService(UsersRepository usersRepository, PostsRepository postsRepository) {
        this.usersRepository = usersRepository;
        this.postsRepository = postsRepository;
    }
//*************** USER POST ASSOCIATION *********************
    public void addPost(Post newPost, String username){
//        USER OBJECT WHO MADE THE POST
        User user = getUserByUsername(username);
//        ASSOCIATING THE POST WITH THE USER OBJECT
        user.getPosts().add(newPost);
//        ASSOCIATING THE USER WITH THE POST OBJECT
        newPost.setUser(user);
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
    System.out.println(userToUpdate.getPassword());

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
        if (post.getContent() != null && !post.getContent().isEmpty()){
            postToUpdate.setContent(post.getContent());
        }
        if (post.getTitle() != null && !post.getTitle().isEmpty()){
            postToUpdate.setTitle(post.getTitle());
        }
    }

    //    ******** DELETE POST ************
    public void deletePostById(Long id) {
        postsRepository.deleteById(id);
    }
}




