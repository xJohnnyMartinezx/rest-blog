package com.example.restblog.service;

import com.example.restblog.data.*;
import com.example.restblog.dto.CreateUserDto;
import com.example.restblog.dto.UpdateUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> getUserByEmail(String email) {
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
    public void createUser(CreateUserDto createUserDto) {
        usersRepository.save(new User(
                createUserDto.getUsername(),
                createUserDto.getEmail(),
                createUserDto.getPassword()));
    }

    //    *********** UPDATE USER INFO *************
    public void updateUserProfile(Long id, String username, String email) {
        User profileToUpdate = getUserById(id);
        profileToUpdate.setUsername(username);
        profileToUpdate.setEmail(email);
        System.out.println(profileToUpdate);
        usersRepository.save(profileToUpdate);
    }

    public void updateUser(UpdateUserDto updateUserDto){
        User user = usersRepository.findById(updateUserDto.getId()).orElseThrow();

        if(updateUserDto.getUsername() != null && !updateUserDto.getUsername().isEmpty()){
            user.setUsername(updateUserDto.getUsername());
        }
        if(updateUserDto.getEmail() != null && !updateUserDto.getEmail().isEmpty()){
            user.setEmail(updateUserDto.getEmail());
        }
        usersRepository.save(user);
    }
}




