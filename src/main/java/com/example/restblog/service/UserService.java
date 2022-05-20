package com.example.restblog.service;


import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private List<User> userList = setUserList();
    private List<Post> posts = setPostList();


    public List<User> getUsersList() {
        return userList;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost (Post newPost, String username){
        User user = getUserByUsername(username);

        user.getPosts().add(newPost);

        newPost.setUser(user);

        posts.add(newPost);
    }

    public User getUserById(Long id) {
        for (User user : userList){
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    private List<User> setUserList(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L,"kungfupanda", "panda54@gmail.com", "pandafight"));
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




