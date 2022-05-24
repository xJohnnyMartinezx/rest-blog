package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import com.example.restblog.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //    *********** GET ALL USERS ***********
    @GetMapping()
    public List<User> getAll() {
        return userService.getUsersList();
    }

    //******** GET BY ID *************

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //******** GET BY USERNAME *************
    @GetMapping("/username")
    public User getByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }


    //******** GET BY EMAIL *************
    @GetMapping("/email")
    public User getByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }


    //******** CREATE USER **********
    @PostMapping
    private void createUser(@RequestBody User newUser) {
        userService.getUsersList().add(newUser);
        System.out.println("New user has been created");
    }

    //*********** ADD USER POST ***********
    @PostMapping("{username}")
    public void addUserPost(@PathVariable String username, @RequestBody Post newPost) {
        User user = userService.getUserByUsername(username);
        user.getPosts().add(newPost);
    }

    //    ********* UPDATE USER **********
    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        System.out.println("The id is: " + id);
        System.out.println("User has been updated");
    }

    //    ********* UPDATE PASSWORD **********
    @PutMapping({"{id}/updatePassword"})
    private void updatePassword(@PathVariable Long id,
                                @RequestParam(required = false) String oldPassword,
                                @Valid @Size(min = 3) @RequestParam String newPassword) {
//        User userToUpdate = getById(id);
//        userToUpdate.setPassword(newPassword);
//        System.out.println(userToUpdate.getPassword());
        userService.updateUserPassword(id, oldPassword, newPassword);

    }


    //    ********** DELETE USER **********
    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        System.out.println("User with ID of " + id + " has been deleted");
    }


}
