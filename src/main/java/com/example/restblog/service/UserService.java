package com.example.restblog.service;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
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

    private List<User> userList = setUserList();
    private List<Post> posts = setPostList();

//************************** USER METHODS ****************************
    //    ********** GET ALL USERS ********
    public List<User> getUsersList() {
        return userList;
    }

    //    ******** GET USERS BY ID ***********
    public User getUserById(Long id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
    //    ******** GET USER BY USERNAME ***********
    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    //    ******** GET USER BY EMAIL ***********
    public User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
//    ********** UPDATE USER PASSWORD ***********
private void updateUserPassword(Long id,
                            @RequestParam(required = false) String oldPassword,
                            @Valid @Size(min = 3) String newPassword) {
    User userToUpdate = getUserById(id);
    userToUpdate.setPassword(newPassword);
    System.out.println(userToUpdate.getPassword());
}



    //    ********************** POST METHODS ************************
//    ********** GET ALL POSTS ********
    public List<Post> getAllPosts() {
        return posts;
    }

    //    ******** GET POSTS BY ID ***********
    public Post getPostById(Long id) {
        for (Post post : posts) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return null;
    }

    //    ******** CREATE POST ***********
    public void addPost(Post newPost, String username) {
        User user = getUserByUsername(username);
        user.getPosts().add(newPost);
        newPost.setUser(user);
        posts.add(newPost);
    }

    //    ******** UPDATE POSTS *************
    public void updatePosts(Long id, Post updatedPost) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setContent(updatedPost.getContent());
                post.setTitle(updatedPost.getTitle());
            }
        }
    }

    //    ******** DELETE POST ************
    public void deletePOstById(Long id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                posts.remove(post);
                return;
            }
        }
    }

//******************** OBJECTS LISTS *********************
    private List<User> setUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "kungfupanda", "panda54@gmail.com", "pandafight"));
        users.add(new User(2L, "nacholibre69", "youaretoofat@gmail.com", "eskeleto"));
        users.add(new User(3L, "deweyfinn", "skoolofrock@gmail.com", "guitarbattle"));
        return users;
    }

    private List<Post> setPostList() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "My First Post", "This is the body/contents of my first post."));
        posts.add(new Post(2L, "My Second Post", "This is the body/contents of my second post."));
        posts.add(new Post(3L, "My Third Post", "This is the body/contents of my third post."));
        return posts;
    }
}




