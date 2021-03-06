package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import com.example.restblog.dto.CreateUserDto;
import com.example.restblog.service.UserService;
import com.example.restblog.dto.UpdateUserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    public UsersController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("me")
    public Optional<User> getCurrentUser(OAuth2Authentication auth){
        System.out.println(auth.toString());
        return userService.getUserByEmail(auth.getName());
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
    public Optional<User> getByEmail(@RequestParam String email) {
        return Optional.of(userService.getUserByEmail(email).orElseThrow());
    }


    //******** CREATE USER **********
//    @PostMapping
//    private void addNewUser(@RequestBody CreateUserDto createUserDto) {
//        userService.createUser(createUserDto);
//        System.out.println("New user has been created");
//    }

    @PostMapping("create")
    private void addNewUser(@RequestBody CreateUserDto createUserDto) {
        createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        userService.createUser(createUserDto);
        System.out.println("New user has been created");
    }

    //*********** ADD USER POST ***********
    @PostMapping("{username}")
    public void addUserPost(@PathVariable String username, @RequestBody Post newPost) {
        User user = userService.getUserByUsername(username);
        user.getPosts().add(newPost);
    }

    //    ********* UPDATE USER **********
//    @PutMapping("{id}")
//    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
//        System.out.println("The id is: " + id);
//        System.out.println("User has been updated");
//    }

    //    ********* UPDATE USERNAME AND EMAIL WITH DTO *********
    @PutMapping
    public void update(@RequestBody UpdateUserDto updateUserDto) {
        userService.updateUser(updateUserDto);
        System.out.println("Username and email update successful");
    }

    //    ********* UPDATE PASSWORD **********
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping({"{id}/updatePassword"})
    private void updatePassword(@PathVariable Long id,
                                @RequestParam(required = false) String oldPassword,
                                @Valid @Size(min = 3) @RequestParam String newPassword) {
        userService.updateUserPassword(id, oldPassword, newPassword);

    }
//
//    //    ********** UPDATE USER INFO ***************
//    @PatchMapping("{id}/updateUserProfile")
//    private void updateProfile(@PathVariable Long id, @RequestParam String username, @RequestParam String email) {
//        userService.updateUserProfile(id, username, email);
//        System.out.println("User with ID of " + id + " has been updated....New Username is: " + username + " New Email is: " + email);
//    }


    //    ********** DELETE USER **********
    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        System.out.println("User with ID of " + id + " has been deleted");
    }


}
