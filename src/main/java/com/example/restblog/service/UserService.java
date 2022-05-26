package com.example.restblog.service;

import com.example.restblog.data.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //    INJECTS USER_REPOSITORY AND POSTS_REPOSITORY INTO USER SERVICE CLASS VIA CONSTRUCTOR INJECTION
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
    public void addNewUser(User newUser) {
        usersRepository.save(newUser);
    }

    //    *********** UPDATE USER INFO *************
    public void updateUserProfile(Long id, String username, String email) {
        User profileToUpdate = getUserById(id);
        profileToUpdate.setUsername(username);
        profileToUpdate.setEmail(email);
        System.out.println(profileToUpdate);
        usersRepository.save(profileToUpdate);
    }
}




